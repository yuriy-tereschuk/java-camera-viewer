package ua.myhome.camera.viewer;

import com.github.kokorin.jaffree.ffmpeg.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Objects;

public class FFMpeg implements ActionListener {

    private final String resource;
    private final String id;
    private FFmpegResultFuture fFmpegResultFuture;

    public FFMpeg(String id, String resource) {
        this.id = id;
        this.resource = resource;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        record();
    }

    private void record() {

        if (this.fFmpegResultFuture != null && !this.fFmpegResultFuture.isDone()) {
            this.fFmpegResultFuture.graceStop();
            return;
        }

        Path ffmpegBinDir = Path.of(System.getenv("FFMPEG"));
        this.fFmpegResultFuture =
            FFmpeg.atPath(ffmpegBinDir)
                  .addInput(UrlInput.fromUrl(this.resource))
                  .addOutput(UrlOutput.toPath(Path.of(String.format("output-%s-%%Y%%m%%dT%%H%%M%%S.mp4", this.id))))
                    .setOverwriteOutput(true)
                    .addArgument("-hide_banner")
                    .addArguments("-strftime", "1")
                    .addArguments("-acodec", "copy")
                    .addArguments("-vcodec", "copy")
                    .addArguments("-loglevel", "error")
                    .addArguments("-rtsp_transport", "udp")
                    .addArguments("-use_wallclock_as_timestamps","1")
                    .addArguments("-segment_atclocktime", "1")
                    .addArguments("-f", "segment")
                    .addArguments("-segment_time", "900")
                    .addArguments("-reset_timestamps", "1")
                  .executeAsync();
    }
}
