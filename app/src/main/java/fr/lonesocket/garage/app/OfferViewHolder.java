package fr.lonesocket.garage.app;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fr.lonesocket.garage.library.model.Offer;

public class OfferViewHolder extends RecyclerView.ViewHolder {
    private final TextView mTitle;
    private final ImageView mPlatformIconView;

    public OfferViewHolder(View view) {
        super(view);
        mTitle = view.findViewById(R.id.title);
        mPlatformIconView = view.findViewById(R.id.platform_icon);
    }

    public void setItem(Offer offer) {
        mPlatformIconView.setImageResource(R.drawable.ic_steam);
        mTitle.setText(offer.getGarageLink());
    }
}
