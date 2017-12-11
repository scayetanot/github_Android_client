package com.seb.sebastien.githubclient.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.seb.sebastien.githubclient.R;

/**
 * Created by sebastien on 12/10/17.
 */


public class GitHubGistsViewHolder  extends RecyclerView.ViewHolder{


    TextView user;
    TextView file;
    TextView date;
    ImageView avatar;

    public View itemView;

    public GitHubGistsViewHolder(View itemView) {
        super(itemView);

        this.itemView = itemView;

        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        user = (TextView) itemView.findViewById(R.id.name);
        file = (TextView) itemView.findViewById(R.id.filename);
        date = (TextView) itemView.findViewById(R.id.created);

    }
}

