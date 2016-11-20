package com.eboy.data;

import com.eboy.data.dto.Ad;
import com.eboy.data.keyPhraseModel.KeyPhraseModel;

import java.util.Date;

/**
 * Created by alex on 20.11.16.
 */
public class ExtendedAd {

    Long id;
    String title;
    String description;
    double price;
    String type;
    double latitude;
    double longitude;
    String status;
    Date dateTime;

    String[] keyPhrases;

    public ExtendedAd(Ad ad, KeyPhraseModel keyPhraseModel) {
        this.id = ad.getId();
        this.title = ad.getTitle().getValueAsString();
        this.description = ad.getDescription().getValueAsString();
        this.price = Double.parseDouble(ad.getPrice().getAmount().getValueAsString());
        this.type = ad.getType().getValueAsString();
        this.latitude = Double.parseDouble(ad.getAddress().getLatitude().getValueAsString());
        this.longitude = Double.parseDouble(ad.getAddress().getLongitude().getValueAsString());
        this.status = ad.getStatus().getValueAsString();
         this.dateTime = ad.getDateTime();
        this.keyPhrases = keyPhraseModel.getKeyPhrases(this.id);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getStatus() {
        return status;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String[] getKeyPhrases() {
        return keyPhrases;
    }
}
