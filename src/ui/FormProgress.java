/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;

/**
 *
 * @author sandraarnolds
 */
public class FormProgress {

    Toolbar toolBar = null;
    InfiniteProgress ip = null;
    Form f;
    Container container;

    public FormProgress(Form f) {

        this.f = f;

        if (f.getToolbar() == null) {
            toolBar = new Toolbar();
            f.setToolbar(toolBar);
        }

        toolBar = f.getToolbar();
        toolBar.setUIID("Label");
        ip = new InfiniteProgress();
        

        toolBar.add(BorderLayout.EAST, ip);
        toolBar.revalidate();
        container = null;
    }

    public FormProgress(Form f, Container c) {

        this.f = f;
        container = c;

        ip = new InfiniteProgress();

        container.add(BorderLayout.EAST, ip);
        container.revalidate();
    }

    public void removeProgress() {

        if (container != null) {
            container.removeComponent(ip);
        } else if (toolBar.contains(ip) == true) {
            toolBar.removeComponent(ip);
        }
        f.revalidate();

    }
}
