package io.github.nietscape.spongenv;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.manipulator.mutable.PotionEffectData;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

public class NVCommand implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (! (src instanceof Player)) {
            src.sendMessage(Text.of("You need to be a player to do that!"));
            return CommandResult.empty();
        }
        Player player = (Player)src;
        PotionEffect potion = PotionEffect.builder()
                .potionType(PotionEffectTypes.NIGHT_VISION)
                .duration(Integer.MAX_VALUE)
                .build();
        PotionEffectData effects = player.getOrCreate(PotionEffectData.class).get();
        effects.addElement(potion);
        player.offer(effects);
        player.sendMessage(Text.builder("Enjoy ur nv bruh")
                .style(TextStyles.ITALIC)
                .color(TextColors.AQUA)
                .build());
        return CommandResult.success();
    }
}
