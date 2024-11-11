package splitwise;

import splitwise.models.SplitwiseRecords;
import splitwise.models.User;
import splitwise.models.UserRecords;
import splitwise.services.SplitwiseRecordService;
import splitwise.services.SplitwiseService;
import splitwise.services.UniqueIdGeneratorService;
import splitwise.services.UserService;
import splitwise.servicesImpl.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Set up database like models
        UserRecords userRecords = new UserRecords(new ArrayList<>());
        SplitwiseRecords splitwiseRecords = new SplitwiseRecords(new ArrayList<>());

        //Set up services
        UserService userService = new UserServiceImpl(userRecords);
        UniqueIdGeneratorService uniqueIdGeneratorService = new UniqueIdGeneratorServiceImpl();
        SplitwiseRecordService recordService = new SplitwiseRecordServiceImpl(splitwiseRecords, uniqueIdGeneratorService);
        SplitwiseService splitwiseService = new SplitwiseServiceImpl(userService, recordService);

        //Adding users
        User user1 = new User("u1", "A", "A@gmail.com", "9999999991");
        User user2 = new User("u2", "B", "B@gmail.com", "9999999992");
        User user3 = new User("u3", "C", "C@gmail.com", "9999999993");
        User user4 = new User("u4", "D", "D@gmail.com", "9999999994");
        User user5 = new User("u5", "E", "E@gmail.com", "9999999995");

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);
        userService.addUser(user5);

        // Taking inputs
        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.nextLine();
            SplitwiseGateWayService.execute(s, splitwiseService);
        }
    }
}
