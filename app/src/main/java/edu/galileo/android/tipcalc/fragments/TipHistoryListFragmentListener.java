package edu.galileo.android.tipcalc.fragments;

import edu.galileo.android.tipcalc.models.TipRecord;

/**
 * Created by jonathan on 6/22/2016.
 */
public interface TipHistoryListFragmentListener {
    void addToList(TipRecord record);
    void clearList ();
}
