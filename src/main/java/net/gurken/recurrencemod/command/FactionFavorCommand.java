package net.gurken.recurrencemod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.ToIntFunction;

public class FactionFavorCommand {
    private static final SimpleCommandExceptionType ERROR_SET_POINTS_INVALID = new SimpleCommandExceptionType(Component.translatable("commands.factionfavor.set.points.invalid"));

    public FactionFavorCommand(CommandDispatcher<CommandSourceStack> pDispatcher) {
        LiteralCommandNode<CommandSourceStack> literalcommandnode = pDispatcher.register(Commands.literal("factionfavor").requires((p_137324_) -> {
            return p_137324_.hasPermission(2);
        }).then(Commands.literal("add").then(Commands.argument("targets", EntityArgument.players()).then(Commands.argument("amount", IntegerArgumentType.integer()).executes((p_137341_) -> {
            return addFactionFavor(p_137341_.getSource(), EntityArgument.getPlayers(p_137341_, "targets"), IntegerArgumentType.getInteger(p_137341_, "amount"), net.gurken.recurrencemod.command.FactionFavorCommand.Type.POINTS);
        }).then(Commands.literal("points").executes((p_137339_) -> {
            return addFactionFavor(p_137339_.getSource(), EntityArgument.getPlayers(p_137339_, "targets"), IntegerArgumentType.getInteger(p_137339_, "amount"), net.gurken.recurrencemod.command.FactionFavorCommand.Type.POINTS);
        }))))).then(Commands.literal("set").then(Commands.argument("targets", EntityArgument.players()).then(Commands.argument("amount", IntegerArgumentType.integer(0)).executes((p_137335_) -> {
            return setFactionFavor(p_137335_.getSource(), EntityArgument.getPlayers(p_137335_, "targets"), IntegerArgumentType.getInteger(p_137335_, "amount"), net.gurken.recurrencemod.command.FactionFavorCommand.Type.POINTS);
        }).then(Commands.literal("points").executes((p_137333_) -> {
            return setFactionFavor(p_137333_.getSource(), EntityArgument.getPlayers(p_137333_, "targets"), IntegerArgumentType.getInteger(p_137333_, "amount"), net.gurken.recurrencemod.command.FactionFavorCommand.Type.POINTS);
        }))))).then(Commands.literal("query").then(Commands.argument("targets", EntityArgument.player()).then(Commands.literal("points").executes((p_137322_) -> {
            return queryFactionFavor(p_137322_.getSource(), EntityArgument.getPlayer(p_137322_, "targets"), net.gurken.recurrencemod.command.FactionFavorCommand.Type.POINTS);
        })))));
        pDispatcher.register(Commands.literal("factionfavor").requires((p_137311_) -> {
            return p_137311_.hasPermission(2);
        }).redirect(literalcommandnode));
    }

    private static int queryFactionFavor(CommandSourceStack pSource, ServerPlayer pPlayer, net.gurken.recurrencemod.command.FactionFavorCommand.Type pType) {
        int i = pType.query.applyAsInt(pPlayer);
        pSource.sendSuccess(() -> {
            return Component.translatable("commands.factionfavor.query." + pType.name, pPlayer.getDisplayName(), i);
        }, false);
        return i;
    }

    private static int addFactionFavor(CommandSourceStack pSource, Collection<? extends ServerPlayer> pTargets, int pAmount, net.gurken.recurrencemod.command.FactionFavorCommand.Type pType) {
        for(ServerPlayer serverplayer : pTargets) {
            pType.add.accept(serverplayer, pAmount);
        }

        if (pTargets.size() == 1) {
            pSource.sendSuccess(() -> {
                return Component.translatable("commands.factionfavor.add." + pType.name + ".success.single", pAmount, pTargets.iterator().next().getDisplayName());
            }, true);
        } else {
            pSource.sendSuccess(() -> {
                return Component.translatable("commands.factionfavor.add." + pType.name + ".success.multiple", pAmount, pTargets.size());
            }, true);
        }

        return pTargets.size();
    }

    private static int setFactionFavor(CommandSourceStack pSource, Collection<? extends ServerPlayer> pTargets, int pAmount, net.gurken.recurrencemod.command.FactionFavorCommand.Type pType) throws CommandSyntaxException {
        int i = 0;

        for(ServerPlayer serverplayer : pTargets) {
            if (pType.set.test(serverplayer, pAmount)) {
                ++i;
            }
        }

        if (i == 0) {
            throw ERROR_SET_POINTS_INVALID.create();
        } else {
            if (pTargets.size() == 1) {
                pSource.sendSuccess(() -> {
                    return Component.translatable("commands.factionfavor.set." + pType.name + ".success.single", pAmount, pTargets.iterator().next().getDisplayName());
                }, true);
            } else {
                pSource.sendSuccess(() -> {
                    return Component.translatable("commands.factionfavor.set." + pType.name + ".success.multiple", pAmount, pTargets.size());
                }, true);
            }

            return pTargets.size();
        }
    }

    static enum Type {
        POINTS("points", Player::giveExperiencePoints, (pServerPlayer, pInteger) -> {
            pServerPlayer.setExperienceLevels(pInteger);
            return true;
        }, (serverPlayer) -> {
            return serverPlayer.experienceLevel;
        }),
        LEVELS("levels", ServerPlayer::giveExperienceLevels, (p_137360_, p_137361_) -> {
            p_137360_.setExperienceLevels(p_137361_);
            return true;
        }, (serverPlayer) -> {
            return serverPlayer.experienceLevel;
        });

        public final BiConsumer<ServerPlayer, Integer> add;
        public final BiPredicate<ServerPlayer, Integer> set;
        public final String name;
        final ToIntFunction<ServerPlayer> query;

        private Type(String pName, BiConsumer<ServerPlayer, Integer> pAdd, BiPredicate<ServerPlayer, Integer> pSet, ToIntFunction<ServerPlayer> pQuery) {
            this.add = pAdd;
            this.name = pName;
            this.set = pSet;
            this.query = pQuery;
        }
    }
}
