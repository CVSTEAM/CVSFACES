/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("LetraValidator")
public class LetraValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        Pattern partern = Pattern.compile("w+");
        Matcher matcher = partern.matcher((CharSequence) value);
        HtmlInputText htmlinputtext = (HtmlInputText) component;
        String label;

        if (htmlinputtext.getLabel() == null || htmlinputtext.getLabel().trim().equals("")) {
            label = htmlinputtext.getId();

        } else {
            label = htmlinputtext.getLabel();
        }
        if (!matcher.matches()) {
            FacesMessage facesmensaje = new FacesMessage(label + " no es valido");

            throw new ValidatorException(facesmensaje);
        }
    }

    


}
