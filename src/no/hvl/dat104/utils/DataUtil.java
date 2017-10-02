package no.hvl.dat104.utils;

import java.util.Collections;
import java.util.List;

import no.hvl.dat104.db.Participant;

public class DataUtil {
	
	// Kanskje overflødig sidan ein berre kunne brukt Collection.sort direkte i servleten?
	public static List<Participant> sortList(List<Participant> list) {
		Collections.sort(list);
		return list;
	}
}
