package dev.java.javaexchangerate.controller;

import dev.java.javaexchangerate.dto.CurrencyData;
import dev.java.javaexchangerate.invoker.CurrencyInvoker;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CurryController {

    private CurrencyInvoker currencyInvoker;

    public CurryController(CurrencyInvoker currencyInvoker) {
        this.currencyInvoker = currencyInvoker;
    }

    @RequestMapping("/")
    public String index(Model model) throws IOException {
        CurrencyData currencyData = currencyInvoker.getCurrencyData();

        model.addAttribute("baseCountry", currencyData.getBaseCountry());
        model.addAttribute("baseCurrency", currencyData.getBaseCurrency());
        model.addAttribute("currencyData", currencyData.getCurrencies());

        return "currency";
    }
}
