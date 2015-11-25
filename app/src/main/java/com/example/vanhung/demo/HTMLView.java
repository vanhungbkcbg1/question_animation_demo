package com.example.vanhung.demo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.sufficientlysecure.htmltextview.HtmlTextView;

public class HTMLView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htmlview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String value="<body id=\"tinymce\" class=\"mce-content-body \" data-id=\"content\" contenteditable=\"true\" spellcheck=\"false\"><h1><img style=\"float: right;\" title=\"TinyMCE Logo\" src=\"img/tlogo.png\" alt=\"TinyMCE Logo\" height=\"80\" width=\"92\" data-mce-src=\"img/tlogo.png\" data-mce-style=\"float: right;\">Welcome to the TinyMCE editor demo!</h1><p>Feel free to try out the different features that are provided, please note that the <strong>MoxieManager</strong> specific functionality is part of our commercial offering. The demo is to show the integration.</p><h2>Got questions or need help?</h2><p>If you have questions or need help, feel free to visit our <a href=\"../forum/index.php\" data-mce-href=\"../forum/index.php\">community forum</a>! We also offer Enterprise <a href=\"../enterprise/support.php\" data-mce-href=\"../enterprise/support.php\">support</a> solutions. Also do not miss out on the <a href=\"../wiki.php\" data-mce-href=\"../wiki.php\">documentation</a>, its a great resource wiki for understanding how TinyMCE works and integrates.</p><h2>Found a bug?</h2><p>If you think you have found a bug, you can use the <a href=\"../develop/bugtracker.php\" data-mce-href=\"../develop/bugtracker.php\">Bug Tracker</a> to report bugs to the developers.</p><p>And here is a simple table for you to play with.</p><table border=\"0\" class=\"mce-item-table\"><tbody><tr><td><strong>Product</strong></td><td><strong>Cost</strong></td><td><strong>Really?</strong></td></tr><tr><td>TinyMCE</td><td>Free</td><td>YES!</td></tr><tr><td>Plupload</td><td>Free</td><td>YES!</td></tr></tbody></table><p>Enjoy our software and create great content!</p><p>Oh, and by the way, don't forget to check out our other product called <a href=\"http://www.plupload.com\" target=\"_blank\" data-mce-href=\"http://www.plupload.com\">Plupload</a>, your ultimate upload solution with HTML5 upload support!</p></body>";
        HtmlTextView htmlTextView=(HtmlTextView)findViewById(R.id.html_control);
        htmlTextView.setHtmlFromString(value,new HtmlTextView.RemoteImageGetter());
    }

}
