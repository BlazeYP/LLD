package splitwise.servicesImpl;

import splitwise.exceptions.SplitMatchException;
import splitwise.exceptions.SplitSizeException;
import splitwise.exceptions.SplitTypeException;
import splitwise.services.SplitType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExactSplit extends SplitType {
    public ExactSplit() {
    }

    public ExactSplit(double totalAmount, int numberOfSplits, ArrayList<Double> shareList) {
        super(totalAmount, numberOfSplits, shareList);
    }

    @Override
    public boolean validateSplits() throws SplitTypeException {
        Double totalAmount = 0.0;
        if(Objects.nonNull(shareList)) {
            for (Double amt : shareList) {
                totalAmount += amt;
            }
        }
        if (this.numberOfSplits != shareList.size()) {
            throw new SplitSizeException("Number of splits given doesn't match with shareList size!!");
        }
        if(this.totalAmount != totalAmount) {
            throw new SplitMatchException("Aggregated amount in sharedList doesn't match totalAmount supplied!!");
        }
        return true;
    }

    @Override
    public List<Double> getSplits() throws SplitTypeException{
        try{
            if(validateSplits()) {
                return this.shareList;
            }
        } catch( SplitTypeException e) {
            throw e;
        }
        return null;
    }
}
