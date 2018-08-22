package com.gab.util;


import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;



public class MP3ToPcm {


    /**
     * MP3转换PCM文件方法
     * 
     * @param mp3filepath
     *            原始文件路径
     * @param pcmfilepath
     *            转换文件的保存路径
     * @throws Exception
     */
    public static void convertMP32PCM(String mp3filepath, String pcmfilepath) throws Exception {
        AudioInputStream audioInputStream = getPcmAudioInputStream(mp3filepath);
        AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, new File(pcmfilepath));
    }

    /**
     * 播放MP3方法
     * 
     * @param mp3filepath
     * @throws Exception
     */
    public static void playMP3(String mp3filepath) throws Exception {
        File mp3 = new File(mp3filepath);

        // 播放
        int k = 0, length = 8192;
        AudioInputStream audioInputStream = getPcmAudioInputStream(mp3filepath);
        if (audioInputStream == null)
            System.out.println("null audiostream");
        AudioFormat targetFormat;
        targetFormat = audioInputStream.getFormat();
        byte[] data = new byte[length];
        DataLine.Info dinfo = new DataLine.Info(SourceDataLine.class, targetFormat);
        SourceDataLine line = null;
        try {

            line = (SourceDataLine) AudioSystem.getLine(dinfo);
            line.open(targetFormat);
            line.start();

            int bytesRead = 0;
            byte[] buffer = new byte[length];
            while ((bytesRead = audioInputStream.read(buffer, 0, length)) != -1) {
                line.write(buffer, 0, bytesRead);
            }
            audioInputStream.close();

            line.stop();
            line.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("audio problem " + ex);

        }
    }

    private static AudioInputStream getPcmAudioInputStream(String mp3filepath) {
        File mp3 = new File(mp3filepath);
        AudioInputStream audioInputStream = null;
        AudioFormat targetFormat = null;
        try {
           // = null;
            MpegAudioFileReader mp = new MpegAudioFileReader();
            AudioInputStream in = mp.getAudioInputStream(mp3);
            AudioFormat baseFormat = in.getFormat();
            targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
                    baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
            audioInputStream = AudioSystem.getAudioInputStream(targetFormat, in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return audioInputStream;
    }

    public static void main(String[] args) {
        String path = "D://Documents//Tencent Files//1337440758//FileRecv//";
        String mp3filepath = path + "test.mp3";
        String pcmfilepath = path + "ddd.pcm";

        try {
           MP3ToPcm.convertMP32PCM(mp3filepath, pcmfilepath);
    //      MP3ToPcm.playMP3(mp3filepath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}