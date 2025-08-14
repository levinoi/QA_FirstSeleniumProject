package com.shop.utils;

import com.shop.models.UserData;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object[]> addNewUser() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Lara", "Croft", "Qay123$ddd", "lara001@mail.com"});
        list.add(new Object[]{"Tomb", "Raider", "Qay123$ddd", "tombraider001@mail.com"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewUserFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/userData.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new UserData().setUserName(split[0]).setUserLastName(split[1]).setPassword(split[2]).setEmail(split[3])});
            line = reader.readLine();
        }
        return list.iterator();

    }
}
