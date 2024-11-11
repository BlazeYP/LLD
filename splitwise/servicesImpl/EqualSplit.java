package splitwise.servicesImpl;

import splitwise.exceptions.SplitSizeException;
import splitwise.exceptions.SplitTypeException;
import splitwise.services.SplitType;

import java.util.ArrayList;

public class EqualSplit extends SplitType {
    public EqualSplit() {
    }

    public EqualSplit(double totalAmount, int numberOfSplits) {
        super(totalAmount, numberOfSplits, null);
    }

    @Override
    public boolean validateSplits() throws SplitTypeException{
        if(this.numberOfSplits == 0) {
            throw new SplitSizeException("Number of splits can't be 0 !!");
        }
        return true;
    }

    @Override
    public ArrayList<Double> getSplits() throws  SplitTypeException {
        ArrayList<Double> shareList = null;
        try {
            if(validateSplits()) {
                shareList = new ArrayList<>();
                for(int i=0; i<numberOfSplits; i++) {
                    shareList.add(totalAmount/numberOfSplits);
                }
            }
        } catch ( SplitTypeException e) {
            throw e;
        }
        return shareList;
    }
}
