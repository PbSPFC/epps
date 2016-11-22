package br.uninove.primeiraconsulta.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by PB on 22/11/2016.
 */

public class DataUtil {

    public static String getDate(){
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return sdf.format(data).toString() + " " + c.get(Calendar.HOUR_OF_DAY) + ":" +
                c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
    }

}
