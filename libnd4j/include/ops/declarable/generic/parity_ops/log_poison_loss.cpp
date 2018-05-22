//
//  @author raver119@gmail.com
//

#include <op_boilerplate.h>
#if NOT_EXCLUDED(OP_log_poison_loss)

#include <ops/declarable/headers/parity_ops.h>
#include <ops/declarable/helpers/cross.h>

namespace nd4j {
namespace ops {

    CONFIGURABLE_OP_IMPL(log_poison_loss, 2, 1, true, 0, 0) {

        NDArray<T>* targets = INPUT_VARIABLE(0);
        NDArray<T>* input = INPUT_VARIABLE(1);
        bool computeFullLoss = false;

        if (block.numI() > 0)
            computeFullLoss = INT_ARG(0) != 0;
        
        REQUIRE_TRUE(targets->isSameShape(input), 0, "log_poison_loss: The shape of both input params should be equal.");

        NDArray<T>* output = OUTPUT_VARIABLE(0);
        if (!computeFullLoss)
            targets->template applyPairwiseTransform<simdOps::LogPoisonLoss<T>>(input, output, nullptr);
        else
            targets->template applyPairwiseTransform<simdOps::LogPoisonLossFull<T>>(input, output, nullptr);

        return ND4J_STATUS_OK;
    }
}
}

#endif