/*
 * Copyright (c) 2017 Jacob Rachiele
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to
 * do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE
 * USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * Contributors:
 *
 * Jacob Rachiele
 */
package linear.regression;

import data.DoubleRange;
import data.TestData;
import org.junit.Test;

import java.util.List;

import static data.DoubleFunctions.arrayFrom;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertArrayEquals;

public class LinearRegressionSpec {

    private List<Double> time = DoubleRange.inclusiveRange(1, 47).asList();
    private List<Double> response = TestData.livestock().asList();
    private boolean hasIntercept = true;
    private LinearRegression regression = MultipleLinearRegression.builder()
                                                          .predictor(time)
                                                          .response(response)
                                                          .build();

    @Test
    public void whenBuiltThenDataProperlySet() {
        assertThat(regression.hasIntercept(), is(hasIntercept));
        assertThat(regression.response(), is(response));
        assertThat(regression.predictors().get(0), is(time));
        assertThat(regression.beta(), is(not(nullValue())));
    }

    @Test
    public void whenSimpleRegressionThenBetaEstimatedCorrectly() {
        double[] expected = {217.818827, 4.883391};
        assertArrayEquals(expected, arrayFrom(regression.beta()), 1E-4);
    }
}
