package com.example.a14androidmenukhoitao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button butTon1, butTon2, butTon3;
    TextView textView1;
    RelativeLayout relativeLayout;
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_demo, menu);
        return super.onCreateOptionsMenu(menu);
    }

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
        }
        return super.onOptionsItemSelected(item);
    }
}
