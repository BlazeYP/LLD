package splitwise.servicesImpl;

import splitwise.services.SplitType;
import splitwise.services.SplitwiseService;
import splitwise.utilities.Constants;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class SplitwiseCmdParserService {
    public static void execute(String s, SplitwiseService splitwiseService) {
        if(Objects.nonNull(s) && !s.isBlank()) {
            // Creating a StringTokenizer with space as the default delimiter
            StringTokenizer tokenizer = new StringTokenizer(s);
            ArrayList<String> tokens = new ArrayList<>();

            while (tokenizer.hasMoreTokens()) {
                tokens.add(tokenizer.nextToken().trim());
            }
            switch(tokens.get(0).toUpperCase()) {
                case Constants.SHOW:
                    splitwiseService.show(tokens.size() == 1 ? null : tokens.get(1));
                    break;
                case Constants.EXPENSE:
                    String payerUserId = tokens.get(1);
                    double totalAmount = Float.parseFloat(tokens.get(2));
                    int totalSplits = Integer.parseInt(tokens.get(3));
                    int n = 0;
                    ArrayList<String> borrowerUserList = new ArrayList<>();
                    while(n < totalSplits) {
                        borrowerUserList.add(tokens.get(4 + n));
                        n++;
                    }
                    //Getting SplitType
                    String splitTypeStr = tokens.get(4 + totalSplits);
                    SplitType splitType = SplitType.getSplitTypeObject(splitTypeStr);

                    //Getting sharedAmountList
                    ArrayList<Double> sharedAmountList = new ArrayList<>();
                    for(int i = 4 + totalSplits + 1; i <tokens.size(); i++){
                        sharedAmountList.add(Double.parseDouble(tokens.get(i)));
                    }
                    splitwiseService.addExpense(payerUserId, borrowerUserList, totalAmount, splitType, sharedAmountList);
            }
        }
    }
}
