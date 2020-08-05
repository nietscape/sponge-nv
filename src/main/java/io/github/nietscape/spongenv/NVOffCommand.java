package io.github.nietscape.spongenv;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import java.util.List;
import java.util.Optional;

public class NVOffCommand implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (! (src instanceof Player)) {
            src.sendMessage(Text.of("You need to be a player to do that!"));
            return CommandResult.empty();
        }
        Player player = (Player)src;
        Optional<List<PotionEffect>> optionalEffectList = player.get(Keys.POTION_EFFECTS);
        List<PotionEffect> effectList = optionalEffectList.get();
        effectList.removeIf(eff -> eff.getType() == PotionEffectTypes.NIGHT_VISION);
        player.offer(Keys.POTION_EFFECTS, effectList);
        player.sendMessage(Text.builder("NV Disabled")
                .style(TextStyles.ITALIC)
                .color(TextColors.AQUA)
                .build());
        return CommandResult.success();
    }
}