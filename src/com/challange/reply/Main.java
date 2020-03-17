package com.challange.reply;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Content content = new Content("src/com/challange/reply/a_solar.txt");
        // content.showAllDevs();
        // content.showAllManagers();
        // content.showMap();
        content.getOffice().showDeskCoeficients();
    }
}
