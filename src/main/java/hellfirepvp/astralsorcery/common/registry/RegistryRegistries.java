/*******************************************************************************
 * HellFirePvP / Astral Sorcery 2019
 *
 * All rights reserved.
 * The source code is available on github: https://github.com/HellFirePvP/AstralSorcery
 * For further details, see the License file there.
 ******************************************************************************/

package hellfirepvp.astralsorcery.common.registry;

import hellfirepvp.astralsorcery.common.constellation.ConstellationRegistry;
import hellfirepvp.astralsorcery.common.constellation.IConstellation;
import hellfirepvp.astralsorcery.common.constellation.perk.AbstractPerk;
import hellfirepvp.astralsorcery.common.constellation.perk.tree.PerkTree;
import hellfirepvp.astralsorcery.common.util.sextant.TargetObject;
import net.minecraftforge.registries.*;

import javax.annotation.Nullable;

import static hellfirepvp.astralsorcery.common.lib.RegistriesAS.*;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: RegistryRegistries
 * Created by HellFirePvP
 * Date: 02.06.2019 / 09:18
 */
// Yea don't worry, i'm also having second thoughts at this naming
public class RegistryRegistries {

    private RegistryRegistries() {}

    public static void setupRegistries() {

        REGISTRY_CONSTELLATIONS = new RegistryBuilder<IConstellation>()
                .setName(REGISTRY_NAME_CONSTELLATIONS)
                .setType(IConstellation.class)
                .add((IForgeRegistry.AddCallback<IConstellation>) (owner, stage, id, obj, oldObj) ->
                        ConstellationRegistry.addConstellation(obj))
                .disableSaving()
                .disableOverrides()
                .create();

        REGISTRY_PERKS = (IForgeRegistryModifiable<AbstractPerk>) new RegistryBuilder<AbstractPerk>()
                .setName(REGISTRY_NAME_PERKS)
                .setType(AbstractPerk.class)
                .add((IForgeRegistry.AddCallback<AbstractPerk>) (owner, stage, id, obj, oldObj) ->
                        PerkTree.PERK_TREE.addPerk(obj))
                .disableSaving()
                .disableOverrides()
                .allowModification()
                .create();

        REGISTRY_SEXTANT_TARGET = new RegistryBuilder<TargetObject>()
                .setName(REGISTRY_NAME_SEXTANT_TARGETS)
                .setType(TargetObject.class)
                .disableSaving()
                .disableOverrides()
                .create();

    }

}