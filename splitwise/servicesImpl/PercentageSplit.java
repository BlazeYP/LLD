package splitwise.servicesImpl;

import splitwise.exceptions.SplitMatchException;
import splitwise.exceptions.SplitSizeException;
import splitwise.exceptions.SplitTypeException;
import splitwise.services.SplitType;

import java.util.ArrayList;
import java.util.Objects;

public class PercentageSplit extends SplitType {
    public PercentageSplit() {
    }

    public PercentageSplit(double totalAmount, int numberOfSplits, ArrayList<Double> shareList) {
        super(totalAmount, numberOfSplits, shareList);
    }

    @Override
    public boolean validateSplits() throws SplitTypeException {
        Double totalPercentage = 0.0;
        if(Objects.nonNull(shareList)) {
            for (Double amt : shareList) {
                totalPercentage += amt;
            }
        }
        if(this.numberOfSplits != shareList.size()) {
            throw new SplitSizeException("Number of splits given doesn't match with shareList size!!");
        }
        if (100 != totalPercentage) {
            throw new SplitMatchException("Aggregated percentage in sharedList doesn't match to 100!!");
        }
        return true;
    }

    @Override
    public ArrayList<Double> getSplits() throws SplitTypeException{
        ArrayList<Double> splits = null;
        try {
            if(validateSplits()) {
                splits = new ArrayList<>();
                for(int i=0; i<numberOfSplits; i++) {
                    splits.add((totalAmount*shareList.get(i))/100);
                }
            }
        } catch (SplitTypeException e) {
            throw e;
        }
        return splits;
    }
}
