package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CheckAvailabilityTranslate availabilityExists = new CheckAvailabilityTranslate();
        availabilityExists.checkExistFile();
        Dialog dialog = new Dialog();
        dialog.dialogUser();
    }
}

