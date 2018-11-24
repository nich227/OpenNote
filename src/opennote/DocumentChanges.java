/*
 * First notepad program I have ever written! Don't judge please :3
 */
package opennote;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;

/**
 * Checks to see if any changes are made to a document.
 * @author Kevin Chen
 */
public class DocumentChanges implements javax.swing.event.DocumentListener 
{
    private Stack<String> text_area_history;
    private Stack<String> text_area_removed;
    private boolean previously_blank_text;
    
    public DocumentChanges()
    {
        text_area_history = new Stack<>();
        text_area_removed = new Stack<>();
        previously_blank_text = false;
    }
    
    public void insertUpdate(javax.swing.event.DocumentEvent e)
    {
       history_handling(e);
    }
    
    public void removeUpdate(javax.swing.event.DocumentEvent e)
    {
        history_handling(e);
    }
    
    public void changedUpdate(javax.swing.event.DocumentEvent e) 
    {
        //Plain text components do not fire these events
    }
    
    private void history_handling(javax.swing.event.DocumentEvent e) 
    {
        try {
            
            //This fixes a bug where undos were messing up the stack
            if(e.getDocument().getText(0, e.getDocument().getLength()).equals(""))
            {
                previously_blank_text = true;
                return;
            }
            if(previously_blank_text)
            {
                previously_blank_text = false;
                return;
            }
            
            text_area_history.push(e.getDocument().getText(0, e.getDocument().getLength()));
            
            
            if (text_area_history.size() > 100)
                text_area_history.removeElementAt(0);
            
            //if(do_modification)
            //text_area_history.pop();
            
        } catch (BadLocationException ex) {Logger.getLogger(DocumentChanges.class.getName()).log(Level.SEVERE, null, ex);
}

    }
    
    public void pop()
    {
        if (!text_area_history.isEmpty()) 
        {
            if(!text_area_history.peek().equals(""))
                text_area_removed.add(text_area_history.peek());
            text_area_history.pop();
        }
    }
    
    public String peek()
    {
        if (!text_area_history.isEmpty()) 
        {
            return text_area_history.peek();
        }
        return "";
    }
    
    public void push(String p)
    {
        text_area_history.push(p);
    }
    
    public String readRedo()
    {
        if(!text_area_removed.isEmpty())
        {
            String ele = text_area_removed.peek();
            text_area_removed.pop();
            return ele;
        }
        else
            return null;
    }
    
    public boolean isEmpty()
    {
        return text_area_history.isEmpty();
    }
    
    
}
