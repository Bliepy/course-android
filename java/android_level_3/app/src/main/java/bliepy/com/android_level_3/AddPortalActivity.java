package bliepy.com.android_level_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import bliepy.com.android_level_3.models.PortalModel;

public class AddPortalActivity extends AppCompatActivity {

    private Button addPortal;
    private TextInputEditText url;
    private TextInputEditText name;
    private PortalModel model;
    private String DEFAULT_URL = "https://adfs20.hva.nl/adfs/ls/?SAMLRequest=fZFBb4JAFITv%2FRVk77ALWtGNYGyNqYlGIthDb6%2Bw4Dawa%2FctpD%2B%2FKpq2SePxJTPfm8xMZ19N7XTCoNQqIr7HiCNUrgupqojss6U7JrP4YYrQ1MGRz1t7UDvx2Qq0zhxRGHvyPWuFbSNMKkwnc7HfrSNysPaInFKjNVphvEMHnqrpmUPTdEuhloAUjxthoQALxFmcmFKBvQS52aEoMWA39%2FmiNVLiLLXJxSVNREqoURBntYgIDAflJKzYQA4g%2FGD5IBwGFXtkVV4Wo5MEE0CUnfgxIbZipdCCshEJmD92fd8NRpk%2F5v6Qs9Cb%2BOEbcRKjrc51%2FSRVX01rFNeAErmCRiC3OU%2FnmzUPPMbfexHylyxL3GSbZsR5vVUcnCs%2Bla6Q96XeZx2vj0ncb8Avic1vwn0A3FYi8f%2BbTOlvcHw9%2F24dfwM%3D&SigAlg=http%3A%2F%2Fwww.w3.org%2F2000%2F09%2Fxmldsig%23rsa-sha1&Signature=ctUh2oKzdGVUPVpkv7Kpx8cym0Kq6mTwsSHbVOGW7c0DpOTigN%2FyZ4gaZVygWtkTapUpNT4%2Bac3jPGw5TGgXQJnwRCGEn3XBUkyhgki6jH3SIlUVzpxl%2FHuOo7uKdTaK9bE7I0b34dHUDo2Tpkzr5pHplcF0DVHfusXNlxvaQEXwgePbl%2F1hXat%2BmTNRefZLf2%2FF7vZVEDfmpMjvSakxA24s4WVX1%2FQwkeIAx%2Fpuldbb9ebW%2F2CqQ%2FGkXPZDBFhEJ1q3SocB89bz40I0bAqva0HrltFheVUGHG5pW8iR6kBNRi6nwsu%2FcA4I5JKqiZ3FvAlcpol4RwdNwZJY%2BAlU%2FQ%3D%3D";
    private String DEFAULT_NAME = "hva.nl";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);
        setTitle("AddPortal");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addPortal = findViewById(R.id.addPortalButton);
        url = findViewById(R.id.inputPortalUrl);
        name = findViewById(R.id.inputPortalName);

        name.setText(DEFAULT_NAME);
        url.setText(DEFAULT_URL);

        addPortal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model = new PortalModel();
                model.setName(name.getText().toString());
                model.setUrl(url.getText().toString());

                Intent intent = new Intent(AddPortalActivity.this, WebviewActivity.class);
                intent.putExtra("portal", model);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
