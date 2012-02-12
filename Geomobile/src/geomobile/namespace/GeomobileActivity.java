package geomobile.namespace;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.ProgressBar;
import android.widget.TextView;

public abstract class GeomobileActivity extends Activity implements Runnable {
/*	
	ProgressBar bar;
	TextView txt;

	int total=0;

	boolean isRunning=false;

	// handler for the background updating

	Handler handler=new Handler() {

	@Override

	public void handleMessage(Message msg) {

	total=total+5;

	String perc=String.valueOf(total).toString();

	txt.setText(perc+"% completed");

	bar.incrementProgressBy(5);

	}

	};
    //Adicionado para a progressbar
    
    public void onStart() {
    	super.onStart();

		// reset the bar to the default value of 0	
		bar.setProgress(0);
	
		// create a thread for updating the progress bar
		Thread background=new Thread(new Runnable() {
	
		public void run() {
			try {		
				for (int i=0;i<20 && isRunning;i++) {
			
				// wait 1000ms between each update
				Thread.sleep(1000);			
				handler.sendMessage(handler.obtainMessage());			
				}		
			}
			catch (Throwable t) {
		
			}     }     });

		isRunning=true;
	
		// start the background thread	
		background.start();	
	}

	public void onStop() {
		super.onStop();
		isRunning=false;
	}

	*/
	


	
    /** Called when the activity is first created. */
/*
 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar);
        
        
 /*       
        //Adicionado para a progressbar
        bar=(ProgressBar)findViewById(R.id.progress);
        txt=(TextView)findViewById(R.id.txt);

    }
    */
	
	
	
	private TextView txt;
	private ProgressDialog progDailog;
	private Context curContxt;
	@Override
	public void onCreate(Bundle icicle) {
	super.onCreate(icicle);
	setContentView(R.layout.main);

	txt = (TextView) this.findViewById(R.id.progress);
	txt.setText("Press any key to start Process");
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

	progDailog = ProgressDialog.show(curContxt,
	"Progress dialogue sample ", "ceveni.com please wait....",
	true);
	new Thread() {
	public void run() {
	try{
	// just doing some long operation
	sleep(5000);
	} catch (Exception e) { }
	handler.sendEmptyMessage(0);
	progDailog.dismiss(); }
	}.start();
	return false;
	}//

	private Handler handler = new Handler() {
	@Override
	public void handleMessage(Message msg) {
	txt.setText("Processing Done");

	}
	};

    }