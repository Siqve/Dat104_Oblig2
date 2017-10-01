package no.hvl.dat104.utils;

import java.util.Collections;
import java.util.List;

import no.hvl.dat104.db.Participant;

public class DataUtil {
	
	public static String formatPhoneNumber(String nr) {
		nr = (nr.substring(0,3) + " " + nr.substring(3,5) + " " + nr.substring(5, 8));
		System.out.println(nr);
		return nr;
	}
	
	// Kanskje overflødig sidan ein berre kunne brukt Collection.sort direkte i servleten?
	public static List<Participant> sortList(List<Participant> list) {
		Collections.sort(list);
		return list;
	}
}
