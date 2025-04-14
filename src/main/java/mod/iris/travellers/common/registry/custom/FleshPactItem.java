package mod.iris.travellers.common.registry.custom;

import com.mojang.blaze3d.shaders.Effect;
import mod.maxbogomol.fluffy_fur.FluffyFurClient;
import mod.maxbogomol.fluffy_fur.client.particle.ParticleBuilder;
import mod.maxbogomol.fluffy_fur.client.particle.data.ColorParticleData;
import mod.maxbogomol.fluffy_fur.client.playerskin.PlayerSkin;
import mod.maxbogomol.fluffy_fur.registry.client.FluffyFurParticles;
import mod.maxbogomol.fluffy_fur.registry.client.FluffyFurShaders;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import javax.management.MBeanServerDelegateMBean;
import java.awt.*;

public class FleshPactItem extends Item {
    public FleshPactItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        BlockPos positionInteracted = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        Level pLevel = pContext.getLevel();

        pLevel.explode(player,player.getX(),player.getY(),player.getZ(),20, Level.ExplosionInteraction.MOB);

        ParticleBuilder.create(FluffyFurParticles.SUN).setColorData(ColorParticleData.create(Color.RED).build()).setForce(true).spawn(pContext.getLevel(),player.position());
        player.moveTo(player.position().add(0,10,0));
        player.hurtMarked = true;
        ParticleBuilder.create(FluffyFurParticles.STAR).setColorData(ColorParticleData.create(Color.RED).build()).setForce(true).spawn(pContext.getLevel(),player.position());




        return InteractionResult.SUCCESS;
    }



}
