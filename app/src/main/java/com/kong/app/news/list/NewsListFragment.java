package com.kong.app.news.list;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kong.R;
import com.kong.app.news.NewsEntry;
import com.kong.app.news.NewsFragment;
import com.kong.app.news.adapter.NewsAdapter;
import com.kong.app.news.adapter.OnItemClickListener;
import com.kong.app.news.beans.NewModel;
import com.kong.lib.share.common.fragment.BaseFragment;
import com.kong.lib.share.common.mvp.Injection;
import com.library.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;


public class NewsListFragment extends BaseFragment implements NewsContract.View, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "NewsListFragment";
    private static String FRAGMENT_TYPE_KEY = "type";

    private SwipeRefreshLayout mSwipeRefreshWidget;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private NewsAdapter mAdapter;
    private List<NewModel> mData;
    private NewsContract.Presenter mNewsPresenter;

    private int mType = NewsFragment.NEWS_TYPE_TOP;
    private int pageIndex = 1;

    public static NewsListFragment newInstance(int type) {
        Bundle args = new Bundle();
        NewsListFragment fragment = new NewsListFragment();
        args.putInt(FRAGMENT_TYPE_KEY, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new NewsPresenter(this, Injection.provideSchedulerProvider());
        mType = getArguments().getInt(FRAGMENT_TYPE_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newslist, null);
        mSwipeRefreshWidget = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
        mSwipeRefreshWidget.setColorSchemeResources(R.color.primary,R.color.primary_dark,
                R.color.primary_light, R.color.accent);
        mSwipeRefreshWidget.setOnRefreshListener(this);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new NewsAdapter(getActivity().getApplicationContext());
        mAdapter.setOnItemClickListener(mOnItemClickListener);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mOnScrollListener);
        onRefresh();
        return view;
    }

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {

        private int lastVisibleItem;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == mAdapter.getItemCount()
                    && mAdapter.isShowFooter()) {
                pageIndex+=1;
                mNewsPresenter.loadNews(mType, pageIndex);
            }
        }
    };

    private OnItemClickListener mOnItemClickListener = new OnItemClickListener() {

        @Override
        public void onItemClick(View view, int position) {
            NewModel news = mAdapter.getItem(position);
            NewsEntry.get().startDetailActivity(getActivity(),news);
        }
    };

    @Override
    public void showProgress() {
        mSwipeRefreshWidget.setRefreshing(true);
    }

    @Override
    public void addNews(List<NewModel> newsList) {
        mAdapter.isShowFooter(true);
        if(mData == null) {
            mData = new ArrayList<>();
        }
        mData.addAll(newsList);
        if(pageIndex == 1) {
            mAdapter.setNewDate(mData);
        } else {
            if(ListUtils.isEmpty(mData)) {
                mAdapter.isShowFooter(false);
            }
            mAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void hideProgress() {
        mSwipeRefreshWidget.setRefreshing(false);
    }

    @Override
    public void showLoadFailMsg() {
        if(pageIndex == 1) {
            mAdapter.isShowFooter(false);
            mAdapter.notifyDataSetChanged();
        }
        View view = getActivity() == null ? mRecyclerView.getRootView() : getActivity().findViewById(R.id.main_drawer_layout);
        Snackbar.make(view, getString(R.string.load_fail), Snackbar.LENGTH_SHORT).show();
    }

    private boolean isEnd = false;

    @Override
    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
        if (this.isEnd){
            mAdapter.isShowFooter(false);
            mAdapter.notifyDataSetChanged();
            View view = getActivity() == null ? mRecyclerView.getRootView() : getActivity().findViewById(R.id.main_drawer_layout);
            Snackbar.make(view, getString(R.string.load_end), Snackbar.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onRefresh() {
        pageIndex = 1;
        if(mData != null) {
            mData.clear();
        }
        mNewsPresenter.loadNews(mType, pageIndex);
    }

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {
        mNewsPresenter = presenter;
    }
}
