package henrychuang.tw.chatheadmsg;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


public class MyDialog extends Activity {
	public static boolean active = false;
	public static Activity myDialog;
	
	EditText edt;
	Button btn;
	View top;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog);

		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.main_container);
		setMargins(linearLayout, 0, 0, 0, 0);     //Set The Margin of the dialog according to your need.

		edt = (EditText) findViewById(R.id.dialog_edt);
		btn = (Button) findViewById(R.id.dialog_btn);
		top = (View)findViewById(R.id.dialog_top);
				
		myDialog = MyDialog.this;
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String str = edt.getText().toString();
				if(str.length() > 0){
//					ChatHeadService.showMsg(MyDialog.this, str);
					Intent it = new Intent(MyDialog.this, ChatHeadService.class);
					it.putExtra(Utils.EXTRA_MSG, str);
					startService(it);
				}
			}
		});
		
		
		top.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
	}

	private void setMargins(View view, int left, int top, int right, int bottom) {
		if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
			ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
			p.setMargins(left, top, right, bottom);
			view.requestLayout();
		}
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		active = true;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		active = false;
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		active = false;
	}

	
	
}
