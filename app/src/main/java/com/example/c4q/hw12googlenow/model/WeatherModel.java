package com.example.c4q.hw12googlenow.model;

import java.util.List;

/**
 * Created by joannesong on 2/14/18.
 */

public class WeatherModel {

    private int offset;
    private Daily daily;
    private Currently currently;
    private String timezone;
    private double longitude;
    private double latitude;

    public int getOffset() {
        return offset;
    }

    public Daily getDaily() {
        return daily;
    }

    public Currently getCurrently() {
        return currently;
    }

    public String getTimezone() {
        return timezone;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }


    public static class Daily {
        private List<Data> data;
        private String icon;
        private String summary;

        public List<Data> getData() {
            return data;
        }

        public String getIcon() {
            return icon;
        }

        public String getSummary() {
            return summary;
        }
    }

    public static class Data {
        private int apparentTemperatureMaxTime;
        private double apparentTemperatureMax;
        private int apparentTemperatureMinTime;
        private double apparentTemperatureMin;
        private int temperatureMaxTime;
        private double temperatureMax;
        private int temperatureMinTime;
        private double temperatureMin;
        private double ozone;
        private int visibility;
        private int uvIndexTime;
        private int uvIndex;
        private double cloudCover;
        private int windBearing;
        private int windGustTime;
        private double windGust;
        private double windSpeed;
        private double pressure;
        private double humidity;
        private double dewPoint;
        private int apparentTemperatureLowTime;
        private double apparentTemperatureLow;
        private int apparentTemperatureHighTime;
        private double apparentTemperatureHigh;
        private int temperatureLowTime;
        private double temperatureLow;
        private int temperatureHighTime;
        private double temperatureHigh;
        private String precipType;
        private double precipAccumulation;
        private double precipProbability;
        private int precipIntensityMaxTime;
        private double precipIntensityMax;
        private double precipIntensity;
        private double moonPhase;
        private int sunsetTime;
        private int sunriseTime;
        private String icon;
        private String summary;
        private int time;

        public int getApparentTemperatureMaxTime() {
            return apparentTemperatureMaxTime;
        }

        public double getApparentTemperatureMax() {
            return apparentTemperatureMax;
        }

        public int getApparentTemperatureMinTime() {
            return apparentTemperatureMinTime;
        }

        public double getApparentTemperatureMin() {
            return apparentTemperatureMin;
        }

        public int getTemperatureMaxTime() {
            return temperatureMaxTime;
        }

        public double getTemperatureMax() {
            return temperatureMax;
        }

        public int getTemperatureMinTime() {
            return temperatureMinTime;
        }

        public double getTemperatureMin() {
            return temperatureMin;
        }

        public double getOzone() {
            return ozone;
        }

        public int getVisibility() {
            return visibility;
        }

        public int getUvIndexTime() {
            return uvIndexTime;
        }

        public int getUvIndex() {
            return uvIndex;
        }

        public double getCloudCover() {
            return cloudCover;
        }

        public int getWindBearing() {
            return windBearing;
        }

        public int getWindGustTime() {
            return windGustTime;
        }

        public double getWindGust() {
            return windGust;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public double getPressure() {
            return pressure;
        }

        public double getHumidity() {
            return humidity;
        }

        public double getDewPoint() {
            return dewPoint;
        }

        public int getApparentTemperatureLowTime() {
            return apparentTemperatureLowTime;
        }

        public double getApparentTemperatureLow() {
            return apparentTemperatureLow;
        }

        public int getApparentTemperatureHighTime() {
            return apparentTemperatureHighTime;
        }

        public double getApparentTemperatureHigh() {
            return apparentTemperatureHigh;
        }

        public int getTemperatureLowTime() {
            return temperatureLowTime;
        }

        public double getTemperatureLow() {
            return temperatureLow;
        }

        public int getTemperatureHighTime() {
            return temperatureHighTime;
        }

        public double getTemperatureHigh() {
            return temperatureHigh;
        }

        public String getPrecipType() {
            return precipType;
        }

        public double getPrecipAccumulation() {
            return precipAccumulation;
        }

        public double getPrecipProbability() {
            return precipProbability;
        }

        public int getPrecipIntensityMaxTime() {
            return precipIntensityMaxTime;
        }

        public double getPrecipIntensityMax() {
            return precipIntensityMax;
        }

        public double getPrecipIntensity() {
            return precipIntensity;
        }

        public double getMoonPhase() {
            return moonPhase;
        }

        public int getSunsetTime() {
            return sunsetTime;
        }

        public int getSunriseTime() {
            return sunriseTime;
        }

        public String getIcon() {
            return icon;
        }

        public String getSummary() {
            return summary;
        }

        public int getTime() {
            return time;
        }
    }

    public static class Currently {
        private double ozone;
        private int visibility;
        private int uvIndex;
        private double cloudCover;
        private int windBearing;
        private double windGust;
        private double windSpeed;
        private double pressure;
        private double humidity;
        private double dewPoint;
        private double apparentTemperature;
        private double temperature;
        private String precipType;
        private double precipProbability;
        private double precipIntensityError;
        private double precipIntensity;
        private int nearestStormDistance;
        private String icon;
        private String summary;
        private int time;

        public double getOzone() {
            return ozone;
        }

        public int getVisibility() {
            return visibility;
        }

        public int getUvIndex() {
            return uvIndex;
        }

        public double getCloudCover() {
            return cloudCover;
        }

        public int getWindBearing() {
            return windBearing;
        }

        public double getWindGust() {
            return windGust;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public double getPressure() {
            return pressure;
        }

        public double getHumidity() {
            return humidity;
        }

        public double getDewPoint() {
            return dewPoint;
        }

        public double getApparentTemperature() {
            return apparentTemperature;
        }

        public double getTemperature() {
            return temperature;
        }

        public String getPrecipType() {
            return precipType;
        }

        public double getPrecipProbability() {
            return precipProbability;
        }

        public double getPrecipIntensityError() {
            return precipIntensityError;
        }

        public double getPrecipIntensity() {
            return precipIntensity;
        }

        public int getNearestStormDistance() {
            return nearestStormDistance;
        }

        public String getIcon() {
            return icon;
        }

        public String getSummary() {
            return summary;
        }

        public int getTime() {
            return time;
        }
    }
}
