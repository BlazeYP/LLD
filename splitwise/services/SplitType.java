package splitwise.services;

import splitwise.exceptions.SplitSizeException;
import splitwise.exceptions.SplitTypeException;
import splitwise.servicesImpl.EqualSplit;
import splitwise.servicesImpl.ExactSplit;
import splitwise.servicesImpl.PercentageSplit;

import java.util.ArrayList;
import java.util.List;

public abstract class SplitType {
    protected double totalAmount;
    protected int numberOfSplits;
    protected ArrayList<Double> shareList;

    public SplitType() {
    }

    public SplitType(double totalAmount, int numberOfSplits, ArrayList<Double> shareList) {
        this.totalAmount = totalAmount;
        this.numberOfSplits = numberOfSplits;
        this.shareList = shareList;
    }

    public abstract boolean validateSplits() throws SplitTypeException;
    public abstract List<Double> getSplits() throws SplitTypeException;

    public static SplitType getSplitTypeObject(String splitType) {
        SplitType splitTypeObject = null;
        switch(splitType.toUpperCase()) {
            case "EQUAL" :
                splitTypeObject = new EqualSplit();
                break;
            case "EXACT":
                splitTypeObject = new ExactSplit();
                break;
            case "PERCENT":
                splitTypeObject = new PercentageSplit();
        }
        return splitTypeObject;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getNumberOfSplits() {
        return numberOfSplits;
    }

    public void setNumberOfSplits(int numberOfSplits) {
        this.numberOfSplits = numberOfSplits;
    }

    public ArrayList<Double> getShareList() {
        return shareList;
    }

    public void setShareList(ArrayList<Double> shareList) {
        this.shareList = shareList;
    }
}
