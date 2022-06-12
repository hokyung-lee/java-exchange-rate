package dev.java.javaexchangerate.invoker;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.java.javaexchangerate.dto.CurrencyData;
import dev.java.javaexchangerate.dto.CurrencyInvokerResponse;
import dev.java.javaexchangerate.model.Currency;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class CurrencyInvoker {

    private ObjectMapper objectMapper = new ObjectMapper();

    public CurrencyData getCurrencyData() throws IOException {
        CurrencyInvokerResponse currencyInvokerResponse = executeInvoker();

        CurrencyData currencyData = generateResult(currencyInvokerResponse);

        return currencyData;
    }

    private CurrencyInvokerResponse executeInvoker() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://api.apilayer.com/currency_data/live?source=USD&currencies=KRW%2CJPY%2CPHP")
                .addHeader("apikey", "9BWxYKYmiLOsWjM3XUo62q2uwUXtYPwc")
                .get()
                .build();
        Response response = client.newCall(request).execute();
        response.body();

        CurrencyInvokerResponse currencyInvokerResponse = objectMapper.readValue(response.body().string(),
                CurrencyInvokerResponse.class);
        return currencyInvokerResponse;
    }

    @NotNull
    private CurrencyData generateResult(CurrencyInvokerResponse currencyInvokerResponse) {
        String baseCurrency = currencyInvokerResponse.getSource();

        CurrencyData currencyData = new CurrencyData();
        currencyData.setBaseCountry(countryNameMapper(baseCurrency));
        currencyData.setBaseCurrency(baseCurrency);

        List<Currency> currencies = new ArrayList<>();
        for (Map.Entry<String, Double> entry : currencyInvokerResponse.getQuotes().entrySet()) {
            String currency = entry.getKey().replace(baseCurrency, "");
            Double exchangeRate = entry.getValue();

            currencies.add(new Currency(countryNameMapper(currency), currency, exchangeRate));
        }
        currencyData.setCurrencies(currencies);
        return currencyData;
    }

    private String countryNameMapper(String currency) {
        // 추후 별도 분리
        Map<String, String> map = new HashMap<>();
        map.put("USD", "미국");
        map.put("KRW", "한국");
        map.put("JPY", "일본");
        map.put("PHP", "필리핀");

        return map.getOrDefault(currency, "알수없음");
    }
}
