/**

Copyright (C) SYSTAP, LLC 2006-2011.  All rights reserved.

Contact:
     SYSTAP, LLC
     4501 Tower Road
     Greensboro, NC 27410
     licenses@bigdata.com

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; version 2 of the License.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/
package com.bigdata.bop.joinGraph.rto;

import com.bigdata.bop.IBindingSet;

/**
 * A sample of an {@link Edge} (a join).
 */
public class EdgeSample extends SampleBase {

//    private static final transient Logger log = Logger
//            .getLogger(EdgeSample.class);

//    /**
//     * The estimated cardinality of the cutoff join.
//     */
//    public final long estimatedCardinality;
//
//    /**
//     * The limit used to sample the cutoff join.
//     */
//    public final int limit;
//
//    /**
//     * Indicates whether the estimate is exact, an upper bound, or a lower
//     * bound.
//     */
//    public final EstimateEnum estimateEnum;
//
//    /**
//     * The sample of the solutions for the join path.
//     */
//    final IBindingSet[] sample;

    /**
     * The source sample used to compute the cutoff join.
     */
    public final SampleBase sourceSample;
    
//    /**
//     * The estimated cardinality of the source sample.
//     */
//    public final long sourceEstimatedCardinality;
//
//    /**
//     * The sample type for the source sample.
//     */
//    public final EstimateEnum sourceEstimateEnum;
//
//    /**
//     * Return <code>true</code> iff the source sample is exact (because the
//     * source is either a fully materialized vertex or an edge whose solutions
//     * have been fully materialized).
//     */
//    public boolean isSourceSampleExact() {
//
//        return sourceEstimateEnum == EstimateEnum.Exact;
//
//    }

    /**
     * The #of binding sets out of the source sample vertex sample which were
     * consumed.
     */
    public final int inputCount;

    /**
     * The #of binding sets generated before the join was cutoff.
     * <p>
     * Note: If the outputCount is zero then this is a good indicator that there
     * is an error in the query such that the join will not select anything.
     * This is not 100%, merely indicative.
     */
    public final long outputCount;

    /**
     * The ratio of the #of input samples consumed to the #of output samples
     * generated (the join hit ratio or scale factor).
     */
    public final double f;

    /**
     * Create an object which encapsulates a sample of an edge.
     * 
     * @param sourceSample
     *            The input sample.
     * @param limit
     *            The limit used to sample the edge (this is the limit on the
     *            #of solutions generated by the cutoff join used when this
     *            sample was taken).
     * @param inputCount
     *            The #of binding sets out of the source sample vertex sample
     *            which were consumed.
     * @param outputCount
     *            The #of binding sets generated before the join was cutoff.
     */
//    * @param sourceVertexSample
//    *            The sample for source vertex of the edge (whichever vertex has
//    *            the lower cardinality).
    EdgeSample(
            // final VertexSample sourceVertexSample,
            final SampleBase sourceSample,//
//            final long sourceEstimatedCardinality,//
//            final EstimateEnum sourceEstimateEnum, // 
//            final int sourceSampleLimit,//
            final int inputCount, //
            final long outputCount,//
            final double f, //
            // args to SampleBase
            final long estimatedCardinality,//
            final int limit,//
            final EstimateEnum estimateEnum,//
            final IBindingSet[] sample//
            ) {

        super(estimatedCardinality, limit, estimateEnum, sample);

        if(sourceSample == null)
            throw new IllegalArgumentException();

        this.sourceSample = sourceSample;

//        this.sourceEstimatedCardinality = sourceSample.estimatedCardinality;
//
//        this.sourceEstimateEnum = sourceSample.estimateEnum;

        this.inputCount = inputCount;

        this.outputCount = outputCount;

        this.f = f;

    }

    @Override
    protected void toString(final StringBuilder sb) {
//        return getClass().getName() //
//                + "{ estimatedCardinality=" + estimatedCardinality//
//                + ", limit=" + limit //
//                + ", estimateEnum=" + estimateEnum//
        sb.append(", sourceEstimatedCardinality=" + sourceSample.estimatedCardinality);
        sb.append(", sourceEstimateEnum=" + sourceSample.estimateEnum);
        sb.append(", inputCount=" + inputCount);
        sb.append(", outputCount=" + outputCount);
        sb.append(", f=" + f);
                // + ", estimateIsLowerBound=" + estimateIsLowerBound//
                // + ", estimateIsUpperBound=" + estimateIsUpperBound//
                // + ", sampleIsExactSolution=" + estimateIsExact //
//                + "}";
    }

}
