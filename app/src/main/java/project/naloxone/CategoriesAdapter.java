package project.naloxone;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by John on 2017-11-24.
 */

public class CategoriesAdapter extends BaseExpandableListAdapter {

    private Context ctx;
    private HashMap<String, List<String>> naloxone_category;
    private List<String> naloxone_list;

    public CategoriesAdapter(Context ctx, HashMap<String, List<String>> naloxone_category, List<String> naloxone_list)
    {
        this.ctx = ctx;
        this.naloxone_category = naloxone_category;
        this.naloxone_list = naloxone_list;
    }


    @Override
    public int getGroupCount() {
        return naloxone_list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return naloxone_category.get(naloxone_list.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return naloxone_list.get(i);
    }

    @Override
    public Object getChild(int parent, int child) {
        return naloxone_category.get(naloxone_list.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int parent, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertView, ViewGroup parentView) {
        String group_title = (String) getGroup(parent);
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.parent_layout,parentView, false);
        }
        TextView parent_textview = convertView.findViewById(R.id.parent_txt);
        parent_textview.setTypeface(null, Typeface.BOLD);
        parent_textview.setText(group_title);
        parent_textview.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20f);

        return convertView;
    }

    @Override
    public View getChildView(int parent, int child, boolean lastChild, View convertView, ViewGroup parentView) {
        String child_title = (String) getChild(parent,child);
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_layout, parentView,false);
        }
        TextView child_textview = convertView.findViewById(R.id.child_text);
        child_textview.setText(child_title);
        //child_textview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40f);
        child_textview.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15f);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
