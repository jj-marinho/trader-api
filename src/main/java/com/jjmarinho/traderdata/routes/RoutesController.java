package com.jjmarinho.traderdata.routes;

import com.jjmarinho.traderdata.models.Trade;
import com.jjmarinho.traderdata.responses.PathResponse;
import com.jjmarinho.traderdata.responses.TraderTotalResponse;
import com.jjmarinho.traderdata.services.CSVGeneratorService;
import com.jjmarinho.traderdata.services.FinancialDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping(path = "/")
public class RoutesController {

    @Autowired
    CSVGeneratorService csvService;

    @Autowired
    FinancialDataService finDataService;

    @RequestMapping(path = "/createNewFile")
    public PathResponse createNewFile() throws IOException{
        Path path = csvService.generateCSV();

        PathResponse response = new PathResponse(path);

        return response;
    }

    @RequestMapping(path = "/financialByTrader")
    public ArrayList<TraderTotalResponse> financialByTrader() {
        ArrayList<TraderTotalResponse> response = finDataService.getFinancialDataByTrader();

        return response;
    }
}

