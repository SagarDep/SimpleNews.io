package com.kong.app.demo;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.kong.R;
import com.kong.app.badminton.PlayersActivity;
import com.kong.app.demo.about.AboutActivity2;
import com.kong.app.demo.about.AboutActivity3;
import com.kong.app.demo.me.MeActivity;
import com.kong.app.demo.note.NoteActivity;
import com.kong.app.demo.person.PersonActivity;
import com.kong.app.news.base.ThemeActivity;
import com.kong.app.news.beans.ItemModel;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by CaoPengfei on 17/6/9.
 */

public class DemoActivity extends ThemeActivity {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private static final int[] sId = {R.raw.demo};
    private List<ItemModel> mNoteModels;
    private MultiTypeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        initBar();
        initList();
    }

    private void initBar() {
        mToolbar = (Toolbar) findViewById(R.id.demo_toolbar);
        initToolBar(mToolbar, R.string.demo);
    }

    private void initList() {
        mRecyclerView = (RecyclerView) findViewById(R.id.note_recycle_view);
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(ItemModel.class, new DemoItemViewBinder());
        mRecyclerView.setAdapter(mAdapter);
        mNoteModels = new ArrayList<ItemModel>();
        mNoteModels.clear();

        ItemModel model = new ItemModel();
        model.cls = AboutActivity2.class;
        model.name = "About2Demo";
        model.type = ItemModel.TYPE_OTHERCLASS;
        mNoteModels.add(model);

        ItemModel model1 = new ItemModel();
        model1.cls = NoteActivity.class;
        model1.name = "TabLayoutDemo";
        model.id = R.raw.demo;
        model1.type = ItemModel.TYPE_NOTE;
        mNoteModels.add(model1);

        ItemModel model2 = new ItemModel();
        model2.cls = AboutActivity3.class;
        model2.name = "About3Demo";
        model2.type = ItemModel.TYPE_OTHERCLASS;
        mNoteModels.add(model2);

        ItemModel model3 = new ItemModel();
        model3.cls = PlayersActivity.class;
        model3.name = "BadmintonDemo";
        model3.type = ItemModel.TYPE_OTHERCLASS;
        mNoteModels.add(model3);

        ItemModel model4 = new ItemModel();
        model4.cls = MeActivity.class;
        model4.name = "MeDemo";
        model4.type = ItemModel.TYPE_OTHERCLASS;
        mNoteModels.add(model4);

        ItemModel model5 = new ItemModel();
        model5.cls = PersonActivity.class;
        model5.name = "PersonDemo";
        model5.type = ItemModel.TYPE_OTHERCLASS;
        mNoteModels.add(model5);

        mAdapter.setItems(mNoteModels);
        mAdapter.notifyDataSetChanged();
    }
}
