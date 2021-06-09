package org.o7planning.qlsv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class userAdapter extends RecyclerView.Adapter<userAdapter.UserViewHolder>{
    private List<user> mListUser;
    public void setData(List<user> list)
    {
        this.mListUser = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        user user = mListUser.get(position);
        if (user == null){
            return;
        }
        holder.tvAddress.setText(user.getAddress());
        holder.tvUsername.setText((user.getUsername()));
        holder.tvGrade.setText(user.getGrade());
        holder.tvSex.setText(user.getSex());
        holder.tvMath.setText(user.getMath());
        holder.tvChemistry.setText(user.getChemistry());
        holder.tvPhysical.setText(user.getPhysical());
    }

    @Override
    public int getItemCount() {
        if(mListUser != null)
        {
            return mListUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView tvUsername;
        private TextView tvAddress;
        private TextView tvGrade;
        private TextView tvMath;
        private TextView tvSex;
        private TextView tvPhysical;
        private TextView tvChemistry;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tv_username);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvGrade = itemView.findViewById(R.id.tv_grade);
            tvSex = itemView.findViewById(R.id.tv_sex);
            tvMath = itemView.findViewById(R.id.tv_math);
            tvPhysical = itemView.findViewById(R.id.tv_physical);
            tvChemistry = itemView.findViewById(R.id.tv_chemistry);


        }
    }
}
