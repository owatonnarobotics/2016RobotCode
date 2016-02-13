///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package org.usfirst.frc.team4624.robot.subsystems;
//
//
//import java.io.IOException;
//
//import javax.sound.sampled.Port.Info;
//
//import org.usfirst.frc.team4624.robot.commands.VisionProcessing;
//
//import com.ni.vision.NIVision;
//import com.ni.vision.NIVision.ContourInfoReport;
//import com.ni.vision.NIVision.DrawMode;
//import com.ni.vision.NIVision.Image;
//import com.ni.vision.NIVision.ShapeMode;
//
//import edu.wpi.first.wpilibj.CameraServer;
//import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.networktables.NetworkTable;
//
//
///**
// *
// * @author Developer
// */
//public class CameraDetection extends Subsystem {
//    
//	
//	
//	private NetworkTable table;
//	
//	private int session;
//	private Image frame;
//	private Image processedFrame;
//	ContourInfoReport info;
//	private NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
//	//WPIBinaryImage bin;
//	
//	private NIVision.Range redThreshold   = new NIVision.Range(170, 255);
//	private NIVision.Range greenThreshold = new NIVision.Range(205, 255);
//	private NIVision.Range blueThreshold  = new NIVision.Range(190, 255);
//	
//	public CameraDetection() {
//		//table = NetworkTable.getTable("./GRIP/myContoursReport");
//		//try {
//		//	new ProcessBuilder("/home/admin/grip").inheritIO().start();
//		//} catch (IOException e) {
//		//	e.printStackTrace();
//		//	System.out.println("\"Something was wrong with initializing Grip\" - The Programmers");
//		//}	
//		
//		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0); // creating image to save camera frame
//		processedFrame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0); // creating image to save processed frame
//		session = NIVision.IMAQdxOpenCamera("cam0",  NIVision.IMAQdxCameraControlMode.CameraControlModeController); // getting reference to camera
//		NIVision.IMAQdxConfigureGrab(session); // getting access to current camera stream
//	}
//
//	public void cameraUpdate() {
//		NIVision.IMAQdxGrab(session, frame, 1); // grab camera frame and save to image
//		//NIVision.imaqDrawShapeOnImage(frame, frame, rect, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_RECT, 0.0f); // draw rectangle on frame
//		//NIVision.imaqColorThreshold(processedFrame, frame, 255, NIVision.ColorMode.RGB, redThreshold, greenThreshold, blueThreshold); // filter colors
//		//info = NIVision.imaqContourInfo(processedFrame);
//		
//		CameraServer.getInstance().setImage(frame); // push frame to server
//		//CameraServer.getInstance().setImage(processedFrame); // push processed frame to server
//	}
//	
//	protected void initDefaultCommand() {
//		setDefaultCommand(new VisionProcessing());
//	}
//	
//	public double getX() {
//		try {
//			table = NetworkTable.getTable("GRIP/myContoursReport");
//			return table.getNumberArray("centerX", new double[0])[0];
//		} catch (Exception e) {
//		    return -1;
//		}
//	}
//	
//	public double getY() {
//		return table.getNumberArray("centerY",  new double[0])[0];
//	}
//	
//	public double getWidth() {
//		return table.getNumberArray("width",  new double[0])[0];
//	}
//	
//	public double getHeight() {
//		return table.getNumberArray("height",  new double[0])[0];
//	}
//	
//	public double getArea() {
//		return table.getNumberArray("area",  new double[0])[0];
//	}
//
////    AxisCamera camera;
////    //Camera constants used for distance calculation
////    final int Y_IMAGE_RES = 640;		//X Image resolution in pixels, should be 120, 240 or 480
////    final double VIEW_ANGLE = 49;		//Axis M1013
////    //final double VIEW_ANGLE = 41.7;		//Axis 206 camera
////    //final double VIEW_ANGLE = 37.4;  //Axis M1011 camera
////    final double PI = 3.141592653;
////
////    //Score limits used for target identification
////    final int  RECTANGULARITY_LIMIT = 40;
////    final int ASPECT_RATIO_LIMIT = 55;
////
////    //Score limits used for hot target determination
////    final int TAPE_WIDTH_LIMIT = 50;
////    final int  VERTICAL_SCORE_LIMIT = 50;
////    final int LR_SCORE_LIMIT = 50;
////
////    //Minimum area of particles to be considered
////    final int AREA_MINIMUM = 150;
////
////    //Maximum number of particles to process
////    final int MAX_PARTICLES = 8;
////    
////    final int RED_MIN   = 80;
////    final int RED_MAX   = 170;
////    final int GREEN_MIN = 115;
////    final int GREEN_MAX = 155;
////    final int BLUE_MIN  = 135;
////    final int BLUE_MAX  = 180; 
////    
////    TargetReport target;
////    
////    //private CriteriaCollection cc;
////    private NIVision.ParticleFilterCriteria2[] cc = new NIVision.ParticleFilterCriteria2[1];
////    ColorImage image;
////    
////    private double distance;
////    
////    public class Scores {
////        double rectangularity;
////        double aspectRatioVertical;
////        double aspectRatioHorizontal;
////    }
////    
////    public class TargetReport {
////		int verticalIndex;
////		int horizontalIndex;
////		boolean Hot;
////		double totalScore;
////		double leftScore;
////		double rightScore;
////		double tapeWidthScore;
////		double verticalScore;
////    }
////    
////    
////    public boolean getPic() {
////        try {
////            
////            image = camera.getImage();
////            System.out.println("Got 'em");
////            return true;
////        } catch (Exception ex) {
////            ex.printStackTrace();
////        }
////        return false;
////    }
////    
////    public void processPic() {
////        target = new TargetReport();
////	int verticalTargets[] = new int[MAX_PARTICLES];
////	int horizontalTargets[] = new int[MAX_PARTICLES];
////	int verticalTargetCount, horizontalTargetCount;
////        
////        try {
////            BinaryImage thresholdImage = image.thresholdRGB(RED_MIN, RED_MAX, GREEN_MIN, GREEN_MAX, BLUE_MIN, BLUE_MAX);
////            
////            //cc = new CriteriaCollection();      // create the criteria for the particle filter
////            //cc.addCriteria(NIVision.MeasurementType.MT_AREA, AREA_MINIMUM, 65535, false);
////            
////            //cc[0] = new NIVision.ParticleFilterCriteria2(NIVision.MeasurementType.MT_AREA, AREA_MINIMUM, 65535, 0, 0);
////            BinaryImage filteredImage = thresholdImage.particleFilter(cc);
////            image.free();
////            
////            //iterate through each particle and score to see if it is a target
////            Scores scores[] = new Scores[filteredImage.getNumberParticles()];
////            horizontalTargetCount = verticalTargetCount = 0;
////                
////                if(filteredImage.getNumberParticles() > 0)
////                {
////			for (int i = 0; i < MAX_PARTICLES && i < filteredImage.getNumberParticles(); i++) {
////			ParticleAnalysisReport report = filteredImage.getParticleAnalysisReport(i);
////                        scores[i] = new Scores();
////					
////			//Score each particle on rectangularity and aspect ratio
////			scores[i].rectangularity = scoreRectangularity(report);
////			scores[i].aspectRatioVertical = scoreAspectRatio(filteredImage, report, i, true);
////			scores[i].aspectRatioHorizontal = scoreAspectRatio(filteredImage, report, i, false);			
////					
////			//Check if the particle is a horizontal target, if not, check if it's a vertical target
////			if(scoreCompare(scores[i], false))
////			{
////                            System.out.println("particle: " + i + "is a Horizontal Target centerX: " + report.center_mass_x + "centerY: " + report.center_mass_y);
////                            horizontalTargets[horizontalTargetCount++] = i; //Add particle to target array and increment count
////			} else if (scoreCompare(scores[i], true)) {
////                            System.out.println("particle: " + i + "is a Vertical Target centerX: " + report.center_mass_x + "centerY: " + report.center_mass_y);
////                            verticalTargets[verticalTargetCount++] = i;  //Add particle to target array and increment count
////			} else {
////                            System.out.println("particle: " + i + "is not a Target centerX: " + report.center_mass_x + "centerY: " + report.center_mass_y);
////			}
////                            System.out.println("rect: " + scores[i].rectangularity + "ARHoriz: " + scores[i].aspectRatioHorizontal);
////                            System.out.println("ARVert: " + scores[i].aspectRatioVertical);	
////			}
////
////			//Zero out scores and set verticalIndex to first target in case there are no horizontal targets
////			target.totalScore = target.leftScore = target.rightScore = target.tapeWidthScore = target.verticalScore = 0;
////			target.verticalIndex = verticalTargets[0];
////			for (int i = 0; i < verticalTargetCount; i++)
////			{
////				ParticleAnalysisReport verticalReport = filteredImage.getParticleAnalysisReport(verticalTargets[i]);
////				for (int j = 0; j < horizontalTargetCount; j++)
////				{
////                                    ParticleAnalysisReport horizontalReport = filteredImage.getParticleAnalysisReport(horizontalTargets[j]);
////                                    double horizWidth, horizHeight, vertWidth, leftScore, rightScore, tapeWidthScore, verticalScore, total;
////	
////                                    //Measure equivalent rectangle sides for use in score calculation
////                                    horizWidth = NIVision.imaqMeasureParticle(filteredImage.image, horizontalTargets[j], 0, NIVision.MeasurementType.MT_EQUIVALENT_RECT_LONG_SIDE);
////                                    vertWidth = NIVision.imaqMeasureParticle(filteredImage.image, verticalTargets[i], 0, NIVision.MeasurementType.MT_EQUIVALENT_RECT_SHORT_SIDE);
////                                    horizHeight = NIVision.imaqMeasureParticle(filteredImage.image, horizontalTargets[j], 0, NIVision.MeasurementType.MT_EQUIVALENT_RECT_SHORT_SIDE);
////						
////                                    //Determine if the horizontal target is in the expected location to the left of the vertical target
////                                    leftScore = ratioToScore(1.2*(verticalReport.boundingRectLeft - horizontalReport.center_mass_x)/horizWidth);
////                                    //Determine if the horizontal target is in the expected location to the right of the  vertical target
////                                    rightScore = ratioToScore(1.2*(horizontalReport.center_mass_x - verticalReport.boundingRectLeft - verticalReport.boundingRectWidth)/horizWidth);
////                                    //Determine if the width of the tape on the two targets appears to be the same
////                                    tapeWidthScore = ratioToScore(vertWidth/horizHeight);
////                                    //Determine if the vertical location of the horizontal target appears to be correct
////                                    verticalScore = ratioToScore(1-(verticalReport.boundingRectTop - horizontalReport.center_mass_y)/(4*horizHeight));
////                                    total = leftScore > rightScore ? leftScore:rightScore;
////                                    total += tapeWidthScore + verticalScore;
////
////                                    //If the target is the best detected so far store the information about it
////                                    if(total > target.totalScore)
////                                    {
////                                            target.horizontalIndex = horizontalTargets[j];
////                                            target.verticalIndex = verticalTargets[i];
////                                            target.totalScore = total;
////                                            target.leftScore = leftScore;
////                                            target.rightScore = rightScore;
////                                            target.tapeWidthScore = tapeWidthScore;
////                                            target.verticalScore = verticalScore;
////                                    }
////                                }
////                                //Determine if the best target is a Hot target
////                                target.Hot = hotOrNot(target);
////                            }
////
////                            if(verticalTargetCount > 0)
////                            {
////                                    //Information about the target is contained in the "target" structure
////                                    //To get measurement information such as sizes or locations use the
////                                    //horizontal or vertical index to get the particle report as shown below
////                                    ParticleAnalysisReport distanceReport = filteredImage.getParticleAnalysisReport(target.verticalIndex);
////                                    distance = computeDistance(filteredImage, distanceReport, target.verticalIndex);
////                                    if(target.Hot)
////                                    {
////                                            RobotMap.hotGoal = true;
////                                            System.out.println("Hot target located");
////                                            System.out.println("Distance: " + distance);
////                                    } else {
////                                            System.out.println("No hot target present");
////                                            System.out.println("Distance: " + distance);
////                                    }
////                            }
////                }
////
////                /**
////                 * all images in Java must be freed after they are used since they are allocated out
////                 * of C data structures. Not calling free() will cause the memory to accumulate over
////                 * each pass of this loop.
////                 */
////                filteredImage.free();
////                thresholdImage.free();
////        } catch (Exception ex){
////            ex.printStackTrace();
////        }
////    }
////    
////    public boolean getIsHot(){
////        return target.Hot; 
////    }
////    
////    public double getDistance(){
////        return distance;
////    }
////    
////     double computeDistance (BinaryImage image, ParticleAnalysisReport report, int particleNumber) {
////            double rectLong, height;
////            int targetHeight;
////
////            rectLong = NIVision.imaqMeasureParticle(image.image, particleNumber, 0, NIVision.MeasurementType.MT_EQUIVALENT_RECT_LONG_SIDE);
////            //using the smaller of the estimated rectangle long side and the bounding rectangle height results in better performance
////            //on skewed rectangles
////            height = Math.min(report.boundingRectHeight, rectLong);
////            targetHeight = 32;
////
////            return Y_IMAGE_RES * targetHeight / (height * 12 * 2 * Math.tan(VIEW_ANGLE*Math.PI/(180*2)));
////    }
////    
////    public double scoreAspectRatio(BinaryImage image, ParticleAnalysisReport report, int particleNumber, boolean vertical)
////    {
////        double rectLong, rectShort, aspectRatio, idealAspectRatio;
////
////        rectLong = NIVision.imaqMeasureParticle(image.image, particleNumber, 0, NIVision.MeasurementType.MT_EQUIVALENT_RECT_LONG_SIDE);
////        rectShort = NIVision.imaqMeasureParticle(image.image, particleNumber, 0, NIVision.MeasurementType.MT_EQUIVALENT_RECT_SHORT_SIDE);
////        idealAspectRatio = vertical ? (4.0/32) : (23.5/4);	//Vertical reflector 4" wide x 32" tall, horizontal 23.5" wide x 4" tall
////	
////        //Divide width by height to measure aspect ratio
////        if(report.boundingRectWidth > report.boundingRectHeight){
////            //particle is wider than it is tall, divide long by short
////            aspectRatio = ratioToScore((rectLong/rectShort)/idealAspectRatio);
////        } else {
////            //particle is taller than it is wide, divide short by long
////            aspectRatio = ratioToScore((rectShort/rectLong)/idealAspectRatio);
////        }
////	return aspectRatio;
////    }
////    
////    /**
////     * Compares scores to defined limits and returns true if the particle appears to be a target
////     * 
////     * @param scores The structure containing the scores to compare
////     * @param outer True if the particle should be treated as an outer target, false to treat it as a center target
////     * 
////     * @return True if the particle meets all limits, false otherwise
////     */
////    boolean scoreCompare(Scores scores, boolean vertical){
////	boolean isTarget = true;
////
////	isTarget &= scores.rectangularity > RECTANGULARITY_LIMIT;
////	if(vertical){
////            isTarget &= scores.aspectRatioVertical > ASPECT_RATIO_LIMIT;
////	} else {
////            isTarget &= scores.aspectRatioHorizontal > ASPECT_RATIO_LIMIT;
////	}
////
////	return isTarget;
////    }
////    
////    /**
////     * Computes a score (0-100) estimating how rectangular the particle is by comparing the area of the particle
////     * to the area of the bounding box surrounding it. A perfect rectangle would cover the entire bounding box.
////     * 
////     * @param report The Particle Analysis Report for the particle to score
////     * @return The rectangularity score (0-100)
////     */
////    double scoreRectangularity(ParticleAnalysisReport report){
////            if(report.boundingRectWidth*report.boundingRectHeight !=0){
////                    return 100*report.particleArea/(report.boundingRectWidth*report.boundingRectHeight);
////            } else {
////                    return 0;
////            }	
////    }
////    
////    	/**
////	 * Converts a ratio with ideal value of 1 to a score. The resulting function is piecewise
////	 * linear going from (0,0) to (1,100) to (2,0) and is 0 for all inputs outside the range 0-2
////	 */
////	double ratioToScore(double ratio)
////	{
////		return (Math.max(0, Math.min(100*(1-Math.abs(1-ratio)), 100)));
////	}
////	
////	/**
////	 * Takes in a report on a target and compares the scores to the defined score limits to evaluate
////	 * if the target is a hot target or not.
////	 * 
////	 * Returns True if the target is hot. False if it is not.
////	 */
////	boolean hotOrNot(TargetReport target)
////	{
////		boolean isHot = true;
////		
////		isHot &= target.tapeWidthScore >= TAPE_WIDTH_LIMIT;
////		isHot &= target.verticalScore >= VERTICAL_SCORE_LIMIT;
////		isHot &= (target.leftScore > LR_SCORE_LIMIT) | (target.rightScore > LR_SCORE_LIMIT);
////		
////		return isHot;
////	}
////    
////    public CameraDetection(){
////        //camera = AxisCamera.getInstance();
////        System.out.println("Started Camera.");
////        cc[0] = new NIVision.ParticleFilterCriteria2(NIVision.MeasurementType.MT_AREA, AREA_MINIMUM, 65535, 0, 0);
////    }
////    
////    protected void initDefaultCommand() {
////        
////    }
//    
//  
//}