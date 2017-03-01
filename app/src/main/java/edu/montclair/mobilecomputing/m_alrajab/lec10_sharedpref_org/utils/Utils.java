package edu.montclair.mobilecomputing.m_alrajab.lec10_sharedpref_org.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by m_alrajab on 2/22/17.
 */

public class Utils {

    public static final String SHARED_PREF_FILENAME="edu.montclair.mobilecomputing.m_alrajab.lec10_sharedpref_org.SHAREDFILE1";
    public static final String KEY_TITLE="Title_";
    public static final String KEY_BODY="Body_";


    public static String[] getListFromFiles(Context context){



        String first_str = "";
        ArrayList<String> listOfNotes = new ArrayList<String>();

        File filesdir = context.getFilesDir();
        long x = filesdir.getFreeSpace() / 1_000_000; //converts  bytes to MB
        File[] filesList = filesdir.listFiles();

        for (File fl : filesList) {
            listOfNotes.add(fl.getName());
        }
        return listOfNotes.toArray(new String[listOfNotes.size()]);
    }
    public static String getBodyFromFile(Context context, String file) {
        String tempstr = "";
        try {
            FileInputStream inputStream = context.openFileInput(file);
            int c;
            while ((c = inputStream.read()) != -1) {
                tempstr += Character.toString((char) c);
            }
            inputStream.close();
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }
        return  tempstr;

    }

    }

