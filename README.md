# ASCII Art Generator

## Overview
This project contains two Java programs and a MATLAB script for generating ASCII art from images. The Java programs convert images into ASCII art with different styles, while the MATLAB script applies FFT-based enhancements to an image.

## Features
### **Java Programs**
1. **AsciiArtGenerator532**
   - Converts an image into ASCII art with color enhancement.
   - Applies gamma correction and brightness adjustment for better contrast.
   - Saves the ASCII output as a PNG image.

2. **AsciiArtGenerator535**
   - Converts an image into simple grayscale ASCII art.
   - Copies the ASCII output directly to the clipboard for easy use.
   - Uses an optimized grayscale mapping for better detail.

### **MATLAB Script**
- **Performs FFT-based enhancement on an image**:
  - Increases brightness.
  - Removes low-frequency noise while preserving details.
  - Saves the processed image as a new file.

## Installation and Usage
### **Java Programs**
1. **Compile and run:**
   ```sh
   javac AsciiArtGenerator532.java AsciiArtGenerator535.java
   java AsciiArtGenerator532
   java AsciiArtGenerator535
   ```
2. **Follow the on-screen prompts:**
   - Enter the image file path.
   - Specify maximum width and height.
   - Provide an output file path (for `AsciiArtGenerator532`).
   - ASCII output will be copied to the clipboard (for `AsciiArtGenerator535`).

### **MATLAB Script**
1. Open the script in MATLAB.
2. Set the input image path and adjust parameters if needed.
3. Run the script to enhance the image and save the processed version.

## Requirements
- **Java Programs**:
  - Java 8 or later
- **MATLAB Script**:
  - MATLAB with Image Processing Toolbox

## Example Usage
### **Java ASCII Art Output Sample**
If the input image for AsciiArtGenerator532 is ![75a57113f4e40776d3a66424f0c85eb268e2dcd1](https://github.com/user-attachments/assets/3551ab4d-5a91-4850-8d7f-4edb57bca1b9)

the output image is 
![ASCII Art](asciiartoutput.png)

If the input image for AsciiArtGenerator535 is ![380-3804216_paper-plane-vector-png](https://github.com/user-attachments/assets/472033d5-7329-4a50-a40c-308774ed171e)

the output generated (which is automatically copied to clipboard) is 
                                                                                                    
                                                                                    :-              
                                                                                  :---              
                                                                                :----:              
                                                                             :-------:              
                                                                           :----=----               
                                                                        :------=-----               
                                                                      :------==-----:               
                                                                   :--------==------                
                                                                 :---------==-------                
                                                               :---------==---------                
                                                            :-----------==---------:                
                                                          :-----------===----------                 
                                                       :-------------===-----------                 
                                                     :--------------===-----------:                 
                                                   :--------------====------------:                 
                                                :----------------====-------------                  
                                              :----------------====---------------                  
                                           :------------------====---------------:                  
                                         :-------------------====----------------                   
                                      :--------------------=====-----------------                   
                                    :---------------------=====-----------------:                   
                                  :---------------------======------------------:                   
                               :-----------------------======-------------------                    
                             :------------------------=====---------------------                    
                          :-------------------------======---------------------:                    
                        :-----------------------=========----------------------                     
                      ------------------========-=======-----------------------                     
                   :------------=========-------========----------------------:                     
                 :------=========--------------=========----------------------:                     
              :-==========-------------------========--==---------------------                      
              :-===-------------------------=======----==---------------------                      
                 :-------------------------=======------==-------------------:                      
                    :--------------------========-------==-------------------                       
                       :----------------========---------==------------------                       
                          :------------========----------==-----------------:                       
                             :-------=========------------==----------------:                       
                                :---========--------------==----------------                        
                                  :========----------------==---------------                        
                                   =======-----------------==--------------:                        
                                   -=====-------------------==-------------:                        
                                   :======------------------==-------------                         
                                    =======------------------==------------                         
                                    ===+=====----------------==-----------:                         
                                    -+++=======---------------==----------                          
                                    :+++========--------------==----------                          
                                     +++========: ------------===--------:                          
                                     =++=======:   :-----------==--------:                          
                                     -++======-      :----------==-------                           
                                     :++=====-         :--------==-------                           
                                      ++=====            :------===-----:                           
                                      =+====               ------==-----                            
                                      :+===:                :----===----                            
                                       +==:                   :---==---:                            
                                       ==-                      :-===--:                            
                                       --                         -==--                             
                                                                   :-=-                             
                                                                     ::                             
                                                                                                    
                                                                                                    
                                                                                                    
  


### **Enhanced Image (MATLAB Output)**
Original Image:

  ![75a57113f4e40776d3a66424f0c85eb268e2dcd1](https://github.com/user-attachments/assets/91fb03c7-5984-41b0-83d9-19ab99db2aef)

Processed Image:

  ![filtered_image_color](https://github.com/user-attachments/assets/299f6f40-6941-4eed-9400-06e7769da810)


## Author
Developed by Priyanka.

---

