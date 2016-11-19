package com.eboy;

import com.eboy.data.EbayAdService;
import com.eboy.data.MsTextAnalyticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BaseController {

    MsTextAnalyticService textAnalyser;
    EbayAdService adService;

    @Autowired
    public BaseController(EbayAdService adService, MsTextAnalyticService textAnalyzer) {
        this.textAnalyser = textAnalyzer;
        this.adService = adService;
    }

    @RequestMapping("/")
    public String wakeUp() {

        return "Bot is awake now :)";
    }

    @RequestMapping("/ads")
    public List getAds() {

        ArrayList<String> keywords = new ArrayList<>();
        keywords.add("macbook");
//        keywords.add("pro");


        return adService.getAdsForKeywords(keywords);
    }

    @RequestMapping("/analyze")
    public String getAnalyse() {


        /* Test JSON-String */
        String text = "{\n" +
            "  \"documents\": [\n" +
            "    {\n" +
            "      \"language\": \"en\",\n" +
            "      \"id\": \"0\",\n" +
            "      \"text\": \"CHRISSON VINTAGE ROAD 1.0 zeichnet sich durch eine unverwechselbare Retro Optik, leichter VINTAGE HI TEN Rahmen in matt mit dezenten Unterlack Dekoren, kraftvollen DUAL PIVOT Bremsen (Alukörper) von PROMAX, qulitative Alukurbel A070 von SHIMANO, 14 Gang A050/A070 SHIMANO Schaltung, Rennsattel von Selle Montegrappa und vieles mehr in nur 10,7kg... Die Bereifung SCHWALBE LUGANO (bis 9 Bar und Kevlar Guard) in schwarz creme macht das Fahrrad absolut vollkommen!\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
        return this.textAnalyser.analyze(text);
    }
}

