package org.jetbrains.plugins.groovy.doc.actions;

import com.intellij.ide.util.PackageChooserDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import com.intellij.psi.PsiPackage;
import org.jetbrains.plugins.grails.GrailsBundle;
import org.jetbrains.plugins.groovy.doc.GroovyDocConfiguration;

import javax.swing.*;
import java.util.List;

/**
 * User: Dmitry.Krasilschikov
 * Date: 14.10.2008
 */
public class GroovyDocAddPackageAction extends AnAction {
  private final JList myPackagesList;
  private final DefaultListModel myDataModel;

  public GroovyDocAddPackageAction(final JList packagesList, final DefaultListModel dataModel) {
    super(GrailsBundle.message("groovydoc.add.package"), GrailsBundle.message("groovydoc.add.package"),
          IconLoader.getIcon("/general/add.png"));
    myPackagesList = packagesList;
    myDataModel = dataModel;
  }

  public void actionPerformed(final AnActionEvent e) {
    final Project project = DataKeys.PROJECT.getData(e.getDataContext());

    PackageChooserDialog chooser = new PackageChooserDialog(GrailsBundle.message("groovydoc.package.title"), project);
    chooser.show();

    final List<PsiPackage> packages = chooser.getSelectedPackages();

    for (PsiPackage aPackage : packages) {
      final String qualifiedName = aPackage.getQualifiedName();

      if ("".equals(qualifiedName)){
        myDataModel.addElement(GroovyDocConfiguration.ALL_PACKAGES);
      }
      myDataModel.addElement(qualifiedName);
    }
  }
}
