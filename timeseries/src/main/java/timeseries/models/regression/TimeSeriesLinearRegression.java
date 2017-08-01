package timeseries.models.regression;

import data.regression.LinearRegressionModel;
import timeseries.TimePeriod;
import timeseries.TimeSeries;

/**
 * A linear regression model for time series data.
 *
 * @author Jacob Rachiele
 * Aug. 01, 2017
 */
public interface TimeSeriesLinearRegression extends LinearRegressionModel {

    TimeSeries observations();

    Intercept intercept();

    TimeTrend timeTrend();

    Seasonal seasonal();

    TimePeriod seasonalCycle();

    int seasonalFrequency();

    /**
     * An indicator for whether a time series regression model has an intercept.
     */
    enum Intercept {
        INCLUDE(1), EXCLUDE(0);

        private final int intercept;

        Intercept(final int intercept) {
            this.intercept = intercept;
        }

        boolean include() {
            return this == INCLUDE;
        }
        int asInt() {
            return this.intercept;
        }
    }

    /**
     * An indicator for whether a time series regression model has a time trend.
     */
    enum TimeTrend {
        INCLUDE(1), EXCLUDE(0);

        private final int timeTrend;

        TimeTrend(final int timeTrend) {
            this.timeTrend = timeTrend;
        }

        boolean include() {
            return this == INCLUDE;
        }
        int asInt() {
            return this.timeTrend;
        }
    }

    /**
     * An indictor for whether a time series regresson model has a seasonal component.
     */
    enum Seasonal {
        INCLUDE(1), EXCLUDE(0);

        private final int seasonal;

        Seasonal(final int seasonal) {
            this.seasonal = seasonal;
        }

        boolean include() {
            return this == INCLUDE;
        }
        int asInt() {
            return this.seasonal;
        }
    }
}
