
package com.pfa.swing;

import javax.swing.Icon;
import javax.swing.JProgressBar;

/**
 *
 * @author safae
 */
public class Progress extends JProgressBar{
 /*       public Icon getImage(){
            return image;
        }
        
        
        public Icon setImage(Icon image){
            this.image=  image;
        }
        
        private Icon image;*/
    private ProgressType progressType=ProgressType.NONE;

    public ProgressType getProgressType() {
        return progressType;
    }

    public void setProgressType(ProgressType progressType) {
        this.progressType = progressType;
    }
    
    public static enum ProgressType{
        NONE, DOWN_FILE, CANCEL, FILE ;
    }

    public Progress() {
        setOpaque(false);
        setUI(new ProgressCircleUI(this));
    }
    
    
}
