package fr.lonesocket.garage.app;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import fr.lonesocket.garage.library.loader.Loader;
import fr.lonesocket.garage.library.loader.LoaderException;
import fr.lonesocket.garage.library.model.Offer;

public class OffersFragment extends Fragment {
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.offers_fragment, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        OffersAdapter adapter = new OffersAdapter(new ArrayList<Offer>());
        mRecyclerView.setAdapter(adapter);
        new LoaderTask(adapter).execute();
    }

    private final static class LoaderTask extends AsyncTask<Void, Void, List<Offer>> {
        private final OffersAdapter mAdapter;

        LoaderTask(OffersAdapter adapter) {
            mAdapter = adapter;
        }

        @Override
        protected List<Offer> doInBackground(Void... voids) {
            Loader loader = new Loader();
            try {
                return loader.getOffers();
            } catch (LoaderException e) {
                Log.d("Loader", "Cannot load the offers : " + e.getMessage(), e);
            }
            return null;
        }

        protected void onPostExecute(List<Offer> offers) {
            mAdapter.update(offers);
        }
    }
}
