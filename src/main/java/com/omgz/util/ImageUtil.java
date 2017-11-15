package com.omgz.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.imageio.ImageIO;


public class ImageUtil {
	
		private Font font = new Font("宋体", Font.BOLD, 18);// 添加字体的属性设置  
	  
	    private Graphics2D g = null;  
	  
	    private int fontsize = 1;  
	    
	    private Color color = Color.white;
	    
	    private Color bgColor = Color.WHITE;
	  
	    private int x = 0;  
	  
	    private int y = 0;  
	  
	    /** 
	     * 导入本地图片到缓冲区 
	     */  
	    public BufferedImage loadImageLocal(String imgName) {  
	        try {  
	            return ImageIO.read(new File(imgName));  
	        } catch (IOException e) {  
	            System.out.println(e.getMessage());  
	        }  
	        return null;  
	    }  
	  
	    /** 
	     * 导入网络图片到缓冲区 
	     */  
	    public BufferedImage loadImageUrl(String imgName) {  
	        try {  
	            URL url = new URL(imgName);  
	            return ImageIO.read(url);  
	        } catch (IOException e) {  
	            System.out.println(e.getMessage());  
	        }  
	        return null;  
	    }  
	  
	    /** 
	     * 生成新图片到本地 
	     */  
	    public void writeImageLocal(File outputfile, BufferedImage img) {  
	        if (outputfile != null && img != null) {  
	            try {  
	               // File outputfile = new File(newImage);  
	                ImageIO.write(img, "jpg", outputfile);  
	            } catch (IOException e) {  
	                System.out.println(e.getMessage());  
	            }  
	        }  
	    }  
	  
	    /** 
	     * 设定文字的字体等 
	     */  
	    public void setFont(String fontStyle, int fontSize) {  
	        this.fontsize = fontSize;  
	        this.font = new Font(fontStyle, Font.PLAIN, fontSize);  
	    }  
	  
	    /** 
	     * 修改图片,返回修改后的图片缓冲区（只输出一行文本） 
	     */  
	    public BufferedImage modifyImage(BufferedImage img, Object content, int x,  
	            int y) {  
	  
	        try {  
	            int w = img.getWidth();  
	            int h = img.getHeight();  
	            g = img.createGraphics();  
	            g.setBackground(bgColor);  
	            g.setColor(color);//设置字体颜色  
	            if (this.font != null)  
	                g.setFont(this.font);  
	            // 验证输出位置的纵坐标和横坐标  
	            if (x >= h || y >= w) {  
	                this.x = h - this.fontsize + 2;  
	                this.y = w;  
	            } else {  
	                this.x = x;  
	                this.y = y;  
	            }  
	            if (content != null) {  
	                g.drawString(content.toString(), this.x, this.y);  
	            }  
	            g.dispose();  
	        } catch (Exception e) {  
	            System.out.println(e.getMessage());  
	        }  
	  
	        return img;  
	    }  
	  
	    /** 
	     * 修改图片,返回修改后的图片缓冲区（输出多个文本段） xory：true表示将内容在一行中输出；false表示将内容多行输出 
	     */  
	    public BufferedImage modifyImage(BufferedImage img, Object[] contentArr,  
	            int x, int y, boolean xory) {  
	        try {  
	            int w = img.getWidth();  
	            int h = img.getHeight();  
	            g = img.createGraphics();  
	            g.setBackground(bgColor);  
	            g.setColor(color);  
	            if (this.font != null)  
	                g.setFont(this.font);  
	            // 验证输出位置的纵坐标和横坐标  
	            if (x >= h || y >= w) {  
	                this.x = h - this.fontsize + 2;  
	                this.y = w;  
	            } else {  
	                this.x = x;  
	                this.y = y;  
	            }  
	            if (contentArr != null) {  
	                int arrlen = contentArr.length;  
	                if (xory) {  
	                    for (int i = 0; i < arrlen; i++) {  
	                        g.drawString(contentArr[i].toString(), this.x, this.y);  
	                        this.x += contentArr[i].toString().length()  
	                                * this.fontsize / 2 + 5;// 重新计算文本输出位置  
	                    }  
	                } else {  
	                    for (int i = 0; i < arrlen; i++) {  
	                        g.drawString(contentArr[i].toString(), this.x, this.y);  
	                        this.y += this.fontsize + 2;// 重新计算文本输出位置  
	                    }  
	                }  
	            }  
	            g.dispose();  
	        } catch (Exception e) {  
	            System.out.println(e.getMessage());  
	        }  
	  
	        return img;  
	    }  
	  
	    /** 
	     * 修改图片,返回修改后的图片缓冲区（只输出一行文本） 
	     *  
	     * 时间:2007-10-8 
	     *  
	     * @param img 
	     * @return 
	     */  
	    public BufferedImage modifyImageYe(BufferedImage img) {  
	  
	        try {  
	            int w = img.getWidth();  
	            int h = img.getHeight();  
	            g = img.createGraphics();  
	            g.setBackground(bgColor);  
	            g.setColor(Color.blue);//设置字体颜色  
	            if (this.font != null)  
	                g.setFont(this.font);  
	            g.drawString("reyo.cn", w - 85, h - 5);  
	            g.dispose();  
	        } catch (Exception e) {  
	            System.out.println(e.getMessage());  
	        }  
	  
	        return img;  
	    }  
	  
	    public BufferedImage modifyImagetogeter(BufferedImage b, BufferedImage d,int x,int y ,int w,int h) {  
	  
	        try {  
//	            int w = 200;  //输出合并的图片宽
//	            int h = 200;  //输出合并的图片高
	  
	            g = d.createGraphics();  
	            g.drawImage(b, x, y, w, h, null);  
	            g.dispose();  
	        } catch (Exception e) {  
	            System.out.println(e.getMessage());  
	        }  
	  
	        return d;  
	    }  
	  
	 public static void main(String[] args) {  
		  
	        ImageUtil tt = new ImageUtil();  
	        BufferedImage d = tt.loadImageUrl("http://static.xiaomeihome.com/bgcode.jpg");  
	        BufferedImage b = tt.loadImageUrl("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQEq8ToAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL1NqbGhGWTNsckhyVlM2RkxGUmZuAAIE2u_oVwMEgDoJAA==");  
	        
	        File file = new File("D:\\53.jpg");
	        tt.writeImageLocal(file,tt.modifyImage(d,"大犀牛",110,130));
	        //往图片上写文字
	        tt.writeImageLocal(file, tt.modifyImagetogeter(b, d,220,450,200,200));  
	        
	        
	        //将多张图片合在一起  
	        System.out.println("success");  
	    }  
}
