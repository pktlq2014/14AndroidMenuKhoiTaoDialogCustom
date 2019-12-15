package com.example.a14androidmenukhoitao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener
{
    Button butTon1, butTon2, butTon3;
    TextView textView1;
    RelativeLayout relativeLayout;
    // share
    ShareActionProvider shareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butTon1 = findViewById(R.id.butTon1);
        butTon2 = findViewById(R.id.butTon2);
        butTon3 = findViewById(R.id.butTon3);
        textView1 = findViewById(R.id.textView1);
        relativeLayout = findViewById(R.id.RelativeLayout);
        butTon1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showMenu();
            }
        });
        textView1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialogLogin();
            }
        });
    }

    private void dialogLogin()
    {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_custom);
        dialog.setCanceledOnTouchOutside(false);
        final EditText editText1 = dialog.findViewById(R.id.editText1);
        final EditText editText2 = dialog.findViewById(R.id.editText2);
        Button butTon2 = dialog.findViewById(R.id.butTon2);
        Button button3 = dialog.findViewById(R.id.butTon3);
        butTon2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String username = editText1.getText().toString();
                String password = editText2.getText().toString();
                if(username.equals("vanty") && password.equals("123456"))
                {
                    Toast.makeText(MainActivity.this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Đăng Nhập Thất Bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // or dialog.cancel();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void showMenu()
    {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, butTon1);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.menuThem:
                    {
                        Toast.makeText(MainActivity.this, "Bạn Click Thêm", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                return false;
            }
        });
        popupMenu.show();
    }
    // gọi dòng này ra ms hiện menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_demo, menu);
        // searchview
        MenuItem menuItem = menu.findItem(R.id.itSearchView);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(MainActivity.this);
        // provider
        MenuItem provider = menu.findItem(R.id.itProvider);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(provider);
        shareActionProvider.setOnShareTargetSelectedListener(new ShareActionProvider.OnShareTargetSelectedListener()
        {
            @Override
            public boolean onShareTargetSelected(ShareActionProvider source, Intent intent)
            {
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                intent1.putExtra(Intent.EXTRA_TEXT, "Hello !");
                shareActionProvider.setShareIntent(intent);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    // thiết lập chức năng khi click vào menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menuSettings:
            {
                Toast.makeText(MainActivity.this, "Bạn Chọn Setting", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menuShare:
            {
                Toast.makeText(MainActivity.this, "Bạn Chọn Share", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.itSearchView:
            {
                Toast.makeText(MainActivity.this, "Bạn Chọn SearchView", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query)
    {
        return false;
    }
    // hiện dữ liệu khi nhập vào thành searchview
    @Override
    public boolean onQueryTextChange(String newText)
    {
        Toast.makeText(MainActivity.this, newText, Toast.LENGTH_SHORT).show();
        return false;
    }
}
