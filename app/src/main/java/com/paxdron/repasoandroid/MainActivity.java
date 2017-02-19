package com.paxdron.repasoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.paxdron.repasoandroid.util.TextChangedListener;

public class MainActivity extends AppCompatActivity {

	private EditText etNombre;
	private Button btnAddContact;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etNombre = (EditText) findViewById(R.id.etNombre);
		btnAddContact = (Button) findViewById(R.id.btnAddContact);
		etNombre.addTextChangedListener(new TextChangedListener() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				btnAddContact.setEnabled(!s.toString().trim().isEmpty());
			}
		});
	}

	public void addContact(View v) {
		String Message= String.format("%s se ha agregado",etNombre.getText());
		Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
		btnAddContact.setEnabled(false);
		limpiarCampos();
	}

	private void limpiarCampos() {
		etNombre.getText().clear();
	}
}
